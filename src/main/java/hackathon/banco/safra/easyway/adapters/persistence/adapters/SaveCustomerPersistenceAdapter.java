package hackathon.banco.safra.easyway.adapters.persistence.adapters;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.mapper.customers.AbstractCustomerPersistenceMapper;
import hackathon.banco.safra.easyway.adapters.persistence.mapper.customers.CustomerPersistenceFactory;
import hackathon.banco.safra.easyway.adapters.persistence.service.CustomerService;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.ports.out.customer.SaveCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveCustomerPersistenceAdapter implements SaveCustomerPort {

    private final CustomerPersistenceFactory factory;
    private final CustomerService service;

    @Override
    public Customer save(Customer customer) {
        Class<? extends Customer> clazz = customer.getClass();
        AbstractCustomerPersistenceMapper mapper = factory.createMapper(clazz);
        CustomerEntity customerEntity = mapper.mapToEntity(customer);
        CustomerEntity savedCustomer = service.save(customerEntity);
        return mapper.mapToDomain(savedCustomer);
    }

}
