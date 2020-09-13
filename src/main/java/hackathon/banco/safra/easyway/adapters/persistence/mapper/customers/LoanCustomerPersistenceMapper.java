package hackathon.banco.safra.easyway.adapters.persistence.mapper.customers;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.LoanCustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.enums.SegmentTypeDataEnum;
import hackathon.banco.safra.easyway.application.domain.customers.LoanCustomer;
import org.springframework.stereotype.Component;

@Component
public class LoanCustomerPersistenceMapper extends AbstractCustomerPersistenceMapper<LoanCustomer, LoanCustomerEntity>{

    public LoanCustomerEntity mapToEntity(LoanCustomer loanCustomer){
        LoanCustomerEntity loanCustomerEntity = super.mapToEntity(loanCustomer);

        loanCustomerEntity.setAge(loanCustomer.getAge());
        loanCustomerEntity.setSegmentType(SegmentTypeDataEnum.fromEnum(loanCustomer.getSegmentType()));
        loanCustomerEntity.setBusinessType(loanCustomer.getBusinessType());

        return loanCustomerEntity;
    }

    public LoanCustomer mapToDomain(LoanCustomerEntity loanCustomerEntity){
        LoanCustomer loanCustomer = super.mapToDomain(loanCustomerEntity);

        loanCustomer.setAge(loanCustomerEntity.getAge());
        loanCustomer.setSegmentType(loanCustomerEntity.getSegmentType().getSegmentTypeEnum());
        loanCustomer.setBusinessType(loanCustomerEntity.getBusinessType());

        return loanCustomer;
    }

    @Override
    protected LoanCustomer newDomainInstance() {
        return new LoanCustomer();
    }

    @Override
    protected LoanCustomerEntity newEntityInstance() {
        return new LoanCustomerEntity();
    }
}
