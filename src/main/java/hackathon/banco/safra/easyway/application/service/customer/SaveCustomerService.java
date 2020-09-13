package hackathon.banco.safra.easyway.application.service.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.ports.in.customer.SaveCustomerUseCase;
import hackathon.banco.safra.easyway.application.ports.out.customer.SaveCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveCustomerService implements SaveCustomerUseCase {

    private final SaveCustomerPort saveCustomerPort;

    @Override
    public Customer save(Customer customer) {
        return saveCustomerPort.save(customer);
    }

}
