package hackathon.banco.safra.easyway.adapters.web.in.mapper;

import hackathon.banco.safra.easyway.adapters.web.in.dto.CustomerInputDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDto;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCustomerWebMapper<D extends Customer> {

    public D mapToDomain(CustomerInputDto customerDto){
        D customer = newDomainInstance();

        customer.setName(customerDto.getName());
        customer.setCpf(customerDto.getCpf());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        return customer;
    }

    public CustomerResponseDto mapToDto(D customer){
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setName(customer.getName());
        customerResponseDto.setCpf(customer.getCpf());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setPhoneNumber(customer.getPhoneNumber());

        return customerResponseDto;
    }

    protected abstract D newDomainInstance();

}
