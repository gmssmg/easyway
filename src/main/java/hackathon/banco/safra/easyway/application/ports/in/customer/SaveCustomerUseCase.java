package hackathon.banco.safra.easyway.application.ports.in.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;

public interface SaveCustomerUseCase {

    Customer save(Customer customer);
}
