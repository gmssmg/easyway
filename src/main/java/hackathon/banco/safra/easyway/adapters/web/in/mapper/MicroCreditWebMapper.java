package hackathon.banco.safra.easyway.adapters.web.in.mapper;


import hackathon.banco.safra.easyway.adapters.web.in.dto.CustomerInputDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDto;
import hackathon.banco.safra.easyway.application.domain.customers.MicroCreditCustomer;
import org.springframework.stereotype.Component;

@Component
public class MicroCreditWebMapper extends AbstractCustomerWebMapper<MicroCreditCustomer> {

    public MicroCreditCustomer mapToDomain(CustomerInputDto customerInputDto){
        MicroCreditCustomer microCreditCustomer = super.mapToDomain(customerInputDto);

        microCreditCustomer.setCreditAmount(customerInputDto.getCreditAmount());

        return microCreditCustomer;
    }

    public CustomerResponseDto mapToDto(MicroCreditCustomer microCreditCustomer){
        CustomerResponseDto customerResponseDto = super.mapToDto(microCreditCustomer);

        customerResponseDto.setCreditAmount(microCreditCustomer.getCreditAmount());

        return customerResponseDto;
    }

    @Override
    protected MicroCreditCustomer newDomainInstance() {
        return new MicroCreditCustomer();
    }

}
