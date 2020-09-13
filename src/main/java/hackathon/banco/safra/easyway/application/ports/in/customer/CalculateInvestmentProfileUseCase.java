package hackathon.banco.safra.easyway.application.ports.in.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;

public interface CalculateInvestmentProfileUseCase {

    Customer calculateProfile(Customer customer);
}
