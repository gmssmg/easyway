package hackathon.banco.safra.easyway.application.service.customer;

import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.ports.in.customer.SearchCustomerUseCase;
import hackathon.banco.safra.easyway.application.ports.out.customer.SearchCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SearchCustomerService implements SearchCustomerUseCase {

    private final SearchCustomerPort searchCustomerPort;


    @Override
    public Optional<Customer> findById(String cpf) {
        return searchCustomerPort.findById(cpf);
    }

    @Override
    public List<Customer> findCustomerByCriteria(CustomerTypeEnum customerType, Integer firstScore, Integer lastScore) {
        return searchCustomerPort.findCustomerByCriteria(customerType, firstScore, lastScore);
    }



}
