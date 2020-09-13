package hackathon.banco.safra.easyway.application.ports.out.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;

public interface SaveCustomerPort {

    Customer save(Customer customer);
}
