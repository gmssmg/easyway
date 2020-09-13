package hackathon.banco.safra.easyway.adapters.persistence.mapper.customers;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCustomerPersistenceMapper<D extends Customer, E extends CustomerEntity> {

    public E mapToEntity(D customer){
        E customerEntity = newEntityInstance();

        customerEntity.setName(customer.getName());
        customerEntity.setCpf(customer.getCpf());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setScore(customer.getScore());

        return customerEntity;
    }

    public D mapToDomain(E customerEntity){
        D customer = newDomainInstance();

        customer.setName(customerEntity.getName());
        customer.setCpf(customerEntity.getCpf());
        customer.setEmail(customerEntity.getEmail());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setScore(customerEntity.getScore());

        return customer;
    }

    protected abstract D newDomainInstance();

    protected abstract E newEntityInstance();
}
