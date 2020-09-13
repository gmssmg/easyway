package hackathon.banco.safra.easyway.application.service.customer;


import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.domain.customers.InvestmentCustomer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.enums.InvestmentProfileEnum;
import hackathon.banco.safra.easyway.application.ports.in.customer.CalculateInvestmentProfileUseCase;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CalculateInvestmentProfileService implements CalculateInvestmentProfileUseCase {

    private static final SecureRandom random = new SecureRandom();

    @Override
    public Customer calculateProfile(Customer customer) {

        if (customer.getCustomerType().equals(CustomerTypeEnum.INVESTMENT)) {
            InvestmentCustomer investmentCustomer = (InvestmentCustomer) customer;
            investmentCustomer.setInvestmentProfile(randomEnum(InvestmentProfileEnum.class));
            return investmentCustomer;
        }

        return customer;
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
