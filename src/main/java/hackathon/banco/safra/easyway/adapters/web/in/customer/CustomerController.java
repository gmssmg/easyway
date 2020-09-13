package hackathon.banco.safra.easyway.adapters.web.in.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.adapters.web.in.dto.CustomerInputDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDataDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseListDto;
import hackathon.banco.safra.easyway.adapters.web.in.mapper.AbstractCustomerWebMapper;
import hackathon.banco.safra.easyway.adapters.web.in.mapper.CustomerWebFactory;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.ports.in.customer.CreateCustomerUseCase;
import hackathon.banco.safra.easyway.application.ports.in.customer.SearchCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("easyway/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerWebFactory factory;
    private final SearchCustomerUseCase searchCustomerUseCase;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerInputDto customerInputDto) throws JsonProcessingException {

        AbstractCustomerWebMapper mapper = factory.createMapper(CustomerTypeEnum.fromDescription(customerInputDto.getCustomerType()));
        Customer customer = mapper.mapToDomain(customerInputDto);

        createCustomerUseCase.create(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/cpf")
    public ResponseEntity<CustomerResponseDataDto> getCustomerById(@PathVariable(value = "cpf", required = true) String cpf){

        Optional<Customer> optionalCustomer = searchCustomerUseCase.findById(cpf);

        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            AbstractCustomerWebMapper mapper = factory.createMapper(customer.getCustomerType());
            CustomerResponseDto customerResponseDto = mapper.mapToDto(customer);

            CustomerResponseDataDto customerResponseDataDto = new CustomerResponseDataDto();
            customerResponseDataDto.setCustomerResponseDto(customerResponseDto);

            return new ResponseEntity<>(customerResponseDataDto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping
    public ResponseEntity<CustomerResponseListDto> getCustomerByCriteria(@RequestParam(value = "customer_type", required = false) String customerType,
                                                                     @RequestParam(value = "first_score", required = false) Integer firstScore,
                                                                     @RequestParam(value = "last_score", required = false) Integer lastScore){

        List<Customer> customers = searchCustomerUseCase.findCustomerByCriteria(CustomerTypeEnum.fromDescription(customerType), firstScore, lastScore);

        if (!customers.isEmpty()){
            CustomerResponseListDto customerResponseListDto = new CustomerResponseListDto();
            for (Customer customer : customers){
                AbstractCustomerWebMapper mapper = factory.createMapper(customer.getCustomerType());
                CustomerResponseDto customerResponseDto = mapper.mapToDto(customer);
                customerResponseListDto.getCustomers().add(customerResponseDto);
            }

            return new ResponseEntity<>(customerResponseListDto, HttpStatus.PARTIAL_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
