package hackathon.banco.safra.easyway.application.ports.out.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;

import java.util.List;
import java.util.Optional;

public interface SearchCustomerPort {

    Optional<Customer> findById(String cpf);
    List<Customer> findCustomerByCriteria(CustomerTypeEnum customerType, Integer firstScore, Integer lastScore);
}
