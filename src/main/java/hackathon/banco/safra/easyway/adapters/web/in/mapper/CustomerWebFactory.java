package hackathon.banco.safra.easyway.adapters.web.in.mapper;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomerWebFactory {

    private static final Map<CustomerTypeEnum, AbstractCustomerWebMapper<? extends Customer>> MAPPERS =
            new LinkedHashMap<>();

    public CustomerWebFactory(InvestmentCustomerWebMapper investmentCustomerWebMapper,
                              LoanCustomerWebMapper loanCustomerWebMapper,
                              MicroCreditWebMapper microCreditWebMapper){
        fillWithDomainMappers(investmentCustomerWebMapper, loanCustomerWebMapper, microCreditWebMapper);
    }

    private void fillWithDomainMappers(InvestmentCustomerWebMapper investmentCustomerWebMapper, LoanCustomerWebMapper loanCustomerWebMapper, MicroCreditWebMapper microCreditWebMapper) {
        MAPPERS.put(CustomerTypeEnum.INVESTMENT, investmentCustomerWebMapper);
        MAPPERS.put(CustomerTypeEnum.LOAN, loanCustomerWebMapper);
        MAPPERS.put(CustomerTypeEnum.MICROCREDIT, microCreditWebMapper);
    }

    public AbstractCustomerWebMapper<? extends Customer> createMapper(CustomerTypeEnum customerTypeEnum){
        if (MAPPERS.containsKey(customerTypeEnum))
            return MAPPERS.get(customerTypeEnum);
        throw new RuntimeException("Unable to find Customer Type");

    }

}
