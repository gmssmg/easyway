package hackathon.banco.safra.easyway.application.service.customer;

import hackathon.banco.safra.easyway.application.ports.in.customer.ValidateCustomerCpfUseCase;
import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerCpfService implements ValidateCustomerCpfUseCase {

    @Override
    public boolean validate(String cpf) {
        return cpf.length() == 11;
    }

}
