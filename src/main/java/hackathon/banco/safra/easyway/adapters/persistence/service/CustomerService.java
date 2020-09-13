package hackathon.banco.safra.easyway.adapters.persistence.service;

import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerEntity save(CustomerEntity customerEntity){
        return repository.saveAndFlush(customerEntity);
    }

    public Optional<CustomerEntity> findById(String cpf) {
        return repository.findById(cpf);
    }

    public List<CustomerEntity> findCustomerByCriteria(CustomerTypeDataEnum customerType, Integer firstScore, Integer lastScore) {
        return repository.findCustomerByCriteria(customerType, firstScore, lastScore);
    }
}
