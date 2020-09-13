package hackathon.banco.safra.easyway.adapters.persistence.mapper.customers;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.MicroCreditCustomerEntity;
import hackathon.banco.safra.easyway.application.domain.customers.MicroCreditCustomer;
import org.springframework.stereotype.Component;

@Component
public class MicroCreditPersistenceMapper extends AbstractCustomerPersistenceMapper<MicroCreditCustomer, MicroCreditCustomerEntity>{

    public MicroCreditCustomerEntity mapToEntity(MicroCreditCustomer microCreditCustomer){
        MicroCreditCustomerEntity microCreditCustomerEntity = super.mapToEntity(microCreditCustomer);

        microCreditCustomerEntity.setCreditAmount(microCreditCustomer.getCreditAmount());

        return microCreditCustomerEntity;
    }

    public MicroCreditCustomer mapToDomain(MicroCreditCustomerEntity microCreditCustomerEntity){
        MicroCreditCustomer microCreditCustomer = super.mapToDomain(microCreditCustomerEntity);

        microCreditCustomer.setCreditAmount(microCreditCustomerEntity.getCreditAmount());

        return microCreditCustomer;
    }

    @Override
    protected MicroCreditCustomer newDomainInstance() {
        return new MicroCreditCustomer();
    }

    @Override
    protected MicroCreditCustomerEntity newEntityInstance() {
        return new MicroCreditCustomerEntity();
    }
}
