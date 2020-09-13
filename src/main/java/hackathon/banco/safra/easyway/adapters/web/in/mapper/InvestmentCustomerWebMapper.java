package hackathon.banco.safra.easyway.adapters.web.in.mapper;

import hackathon.banco.safra.easyway.adapters.web.in.dto.CustomerInputDto;
import hackathon.banco.safra.easyway.adapters.web.in.dto.response.CustomerResponseDto;
import hackathon.banco.safra.easyway.application.domain.customers.InvestmentCustomer;
import org.springframework.stereotype.Component;

@Component
public class InvestmentCustomerWebMapper extends AbstractCustomerWebMapper<InvestmentCustomer> {

    public InvestmentCustomer mapToDomain(CustomerInputDto customerInputDto){
        InvestmentCustomer investmentCustomer = super.mapToDomain(customerInputDto);

        investmentCustomer.setIncome(customerInputDto.getIncome());
        investmentCustomer.setInvestingAmount(customerInputDto.getInvestingAmount());
        investmentCustomer.setRescueTime(customerInputDto.getRescueTime());
        investmentCustomer.setAllowedLossAmount(customerInputDto.getAllowedLossAmount());

        return investmentCustomer;
    }

    public CustomerResponseDto mapToDto(InvestmentCustomer investmentCustomer){
        CustomerResponseDto customerResponseDto = super.mapToDto(investmentCustomer);

        customerResponseDto.setIncome(investmentCustomer.getIncome());
        customerResponseDto.setInvestingAmount(investmentCustomer.getInvestingAmount());
        customerResponseDto.setRescueTime(investmentCustomer.getRescueTime());
        customerResponseDto.setAllowedLossAmount(investmentCustomer.getAllowedLossAmount());

        return customerResponseDto;
    }

    @Override
    protected InvestmentCustomer newDomainInstance() {
        return new InvestmentCustomer();
    }

}
