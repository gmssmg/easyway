package hackathon.banco.safra.easyway.adapters.persistence.adapters;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.mapper.customers.AbstractCustomerPersistenceMapper;
import hackathon.banco.safra.easyway.adapters.persistence.mapper.customers.CustomerPersistenceFactory;
import hackathon.banco.safra.easyway.adapters.persistence.service.CustomerService;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.ports.out.customer.SearchCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SearchCustomerPersistenceAdapter implements SearchCustomerPort {

    private final CustomerPersistenceFactory factory;
    private final CustomerService service;

    @Override
    public Optional<Customer> findById(String cpf) {
        Optional<CustomerEntity> optionalCustomerEntity = service.findById(cpf);
        return optionalMapper(optionalCustomerEntity);
    }

    @Override
    public List<Customer> findCustomerByCriteria(CustomerTypeEnum customerType, Integer firstScore, Integer lastScore) {
        CustomerTypeDataEnum customerTypeDataEnum = CustomerTypeDataEnum.fromEnum(customerType);
        List<CustomerEntity> customerEntityList = service.findCustomerByCriteria(customerTypeDataEnum, firstScore, lastScore);
        List<Customer> customerList = new LinkedList<>();
        for (CustomerEntity customerEntity : customerEntityList){
            Class<? extends CustomerEntity> clazz = customerEntity.getClass();
            AbstractCustomerPersistenceMapper mapper = factory.createMapper(clazz);
            customerList.add(mapper.mapToDomain(customerEntity));
        }
        return customerList;
    }

    private Optional<Customer> optionalMapper(Optional<CustomerEntity> optionalCustomerEntity){
        if(optionalCustomerEntity.isPresent()){
            CustomerEntity customerEntity = optionalCustomerEntity.get();
            Class<? extends CustomerEntity> clazz = customerEntity.getClass();
            AbstractCustomerPersistenceMapper mapper = factory.createMapper(clazz);
            return Optional.of(mapper.mapToDomain(customerEntity));
        }
        return Optional.empty();
    }
}
