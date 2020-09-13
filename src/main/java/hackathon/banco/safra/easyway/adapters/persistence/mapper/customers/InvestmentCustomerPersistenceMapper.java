package hackathon.banco.safra.easyway.adapters.persistence.mapper.customers;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.InvestmentCustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.enums.InvestmentProfileDataEnum;
import hackathon.banco.safra.easyway.application.domain.customers.InvestmentCustomer;
import org.springframework.stereotype.Component;

@Component
public class InvestmentCustomerPersistenceMapper extends AbstractCustomerPersistenceMapper<InvestmentCustomer, InvestmentCustomerEntity>{

    public InvestmentCustomerEntity mapToEntity(InvestmentCustomer investmentCustomer){
        InvestmentCustomerEntity investmentCustomerEntity = super.mapToEntity(investmentCustomer);

        investmentCustomerEntity.setIncome(investmentCustomer.getIncome());
        investmentCustomerEntity.setInvestingAmount(investmentCustomer.getInvestingAmount());
        investmentCustomerEntity.setRescueTime(investmentCustomer.getRescueTime());
        investmentCustomerEntity.setAllowedLossAmount(investmentCustomer.getAllowedLossAmount());
        investmentCustomerEntity.setInvestmentProfile(InvestmentProfileDataEnum.fromEnum(investmentCustomer.getInvestmentProfile()));

        return investmentCustomerEntity;
    }

    public InvestmentCustomer mapToDomain(InvestmentCustomerEntity investmentCustomerEntity){
        InvestmentCustomer investmentCustomer = super.mapToDomain(investmentCustomerEntity);

        investmentCustomer.setIncome(investmentCustomerEntity.getIncome());
        investmentCustomer.setInvestingAmount(investmentCustomerEntity.getInvestingAmount());
        investmentCustomer.setRescueTime(investmentCustomerEntity.getRescueTime());
        investmentCustomer.setAllowedLossAmount(investmentCustomerEntity.getAllowedLossAmount());
        investmentCustomer.setInvestmentProfile(investmentCustomerEntity.getInvestmentProfile().getInvestmentProfileEnum());

        return investmentCustomer;
    }

    @Override
    protected InvestmentCustomer newDomainInstance() {
        return new InvestmentCustomer();
    }

    @Override
    protected InvestmentCustomerEntity newEntityInstance() {
        return new InvestmentCustomerEntity();
    }
}
