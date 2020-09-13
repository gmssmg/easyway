package hackathon.banco.safra.easyway.adapters.persistence.mapper.customers;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.InvestmentCustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.LoanCustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.MicroCreditCustomerEntity;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.domain.customers.InvestmentCustomer;
import hackathon.banco.safra.easyway.application.domain.customers.LoanCustomer;
import hackathon.banco.safra.easyway.application.domain.customers.MicroCreditCustomer;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomerPersistenceFactory {

    private static final Map<Class<?>, AbstractCustomerPersistenceMapper<? extends Customer, ? extends CustomerEntity>> MAPPERS =
            new LinkedHashMap<>();

    public CustomerPersistenceFactory(InvestmentCustomerPersistenceMapper investmentCustomerPersistenceMapper,
                                      LoanCustomerPersistenceMapper loanCustomerPersistenceMapper,
                                      MicroCreditPersistenceMapper microCreditPersistenceMapper){
        fillWithDomainMappers(investmentCustomerPersistenceMapper, loanCustomerPersistenceMapper, microCreditPersistenceMapper);
        fillWithEntityMappers(investmentCustomerPersistenceMapper, loanCustomerPersistenceMapper, microCreditPersistenceMapper);
    }

    private void fillWithDomainMappers(InvestmentCustomerPersistenceMapper investmentCustomerPersistenceMapper, LoanCustomerPersistenceMapper loanCustomerPersistenceMapper, MicroCreditPersistenceMapper microCreditPersistenceMapper) {
        MAPPERS.put(InvestmentCustomer.class, investmentCustomerPersistenceMapper);
        MAPPERS.put(LoanCustomer.class, loanCustomerPersistenceMapper);
        MAPPERS.put(MicroCreditCustomer.class, microCreditPersistenceMapper);
    }

    private void fillWithEntityMappers(InvestmentCustomerPersistenceMapper investmentCustomerPersistenceMapper, LoanCustomerPersistenceMapper loanCustomerPersistenceMapper, MicroCreditPersistenceMapper microCreditPersistenceMapper) {
        MAPPERS.put(InvestmentCustomerEntity.class, investmentCustomerPersistenceMapper);
        MAPPERS.put(LoanCustomerEntity.class, loanCustomerPersistenceMapper);
        MAPPERS.put(MicroCreditCustomerEntity.class, microCreditPersistenceMapper);
    }

    public AbstractCustomerPersistenceMapper<? extends Customer, ? extends CustomerEntity> createMapper(Class<?> clazz){

        List<? extends AbstractCustomerPersistenceMapper<? extends Customer, ? extends CustomerEntity>> collect =
                MAPPERS.entrySet().stream()
                .filter(x -> x.getKey().isAssignableFrom(clazz))
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        if (collect.isEmpty()){
            Class<?> superclass = clazz.getSuperclass();
            if(superclass != null)
                createMapper(superclass);
            throw new RuntimeException("Unable to find Customer Type");
        }
        return collect.stream().findFirst().orElseThrow(() -> new RuntimeException("Unable to find Customer Type"));
    }

}
