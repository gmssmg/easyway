package hackathon.banco.safra.easyway.application.ports.in.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;

public interface CreateCustomerUseCase {

    Customer create(Customer customer) throws JsonProcessingException;
}
