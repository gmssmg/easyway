package hackathon.banco.safra.easyway.adapters.web.in.mapper;

import hackathon.banco.safra.easyway.adapters.web.in.dto.CustomerInputDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDto;
import hackathon.banco.safra.easyway.application.domain.customers.LoanCustomer;
import hackathon.banco.safra.easyway.application.enums.SegmentTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class LoanCustomerWebMapper extends AbstractCustomerWebMapper<LoanCustomer> {

    public LoanCustomer mapToDomain(CustomerInputDto customerInputDto){
        LoanCustomer loanCustomer = super.mapToDomain(customerInputDto);

        loanCustomer.setAge(customerInputDto.getAge());
        loanCustomer.setSegmentType(SegmentTypeEnum.fromDescription(customerInputDto.getSegmentType()));
        loanCustomer.setBusinessType(customerInputDto.getBusinessType());

        return loanCustomer;
    }

    public CustomerResponseDto mapToDto(LoanCustomer loanCustomer){
        CustomerResponseDto customerResponseDto = super.mapToDto(loanCustomer);

        customerResponseDto.setAge(loanCustomer.getAge());
        customerResponseDto.setSegmentType(loanCustomer.getSegmentType().getDescription());
        customerResponseDto.setBusinessType(loanCustomer.getBusinessType());

        return customerResponseDto;
    }

    @Override
    protected LoanCustomer newDomainInstance() {
        return new LoanCustomer();
    }

}
