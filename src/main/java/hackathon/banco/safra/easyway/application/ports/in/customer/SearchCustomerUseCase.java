package hackathon.banco.safra.easyway.application.ports.in.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;

import java.util.List;
import java.util.Optional;

public interface SearchCustomerUseCase {

    Optional<Customer> findById(String cpf);
    List<Customer> findCustomerByCriteria(CustomerTypeEnum customerType, Integer firstScore, Integer lastScore);
}
