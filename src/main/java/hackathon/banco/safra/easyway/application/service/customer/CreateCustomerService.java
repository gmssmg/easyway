package hackathon.banco.safra.easyway.application.service.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.application.domain.customers.Customer;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import hackathon.banco.safra.easyway.application.domain.score.Score;
import hackathon.banco.safra.easyway.application.exception.InvalidCpfException;
import hackathon.banco.safra.easyway.application.ports.in.customer.*;
import hackathon.banco.safra.easyway.application.ports.in.optin.SendOptInUseCase;
import hackathon.banco.safra.easyway.application.ports.in.score.CheckScoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private final SaveCustomerUseCase saveCustomerUseCase;
    private final SearchCustomerUseCase searchCustomerUseCase;
    private final SendOptInUseCase sendOptInUseCase;
    private final CheckScoreUseCase checkScoreUseCase;
    private final CalculateInvestmentProfileUseCase calculateInvestmentProfileUseCase;
    private final ValidateCustomerCpfUseCase validateCustomerCpfUseCase;

    @Override
    public Customer create(Customer customer) throws JsonProcessingException {

        if (!validateCustomerCpfUseCase.validate(customer.getCpf())){
            throw new InvalidCpfException("Please use a valid CPF");
        }

        Optional<Customer> optionalCustomer = searchCustomerUseCase.findById(customer.getCpf());

        if (optionalCustomer.isPresent())
            return optionalCustomer.get();

        Score score = checkScoreUseCase.check(customer.getCpf());

        customer.setScore(score.getScoreGrade());

        customer = calculateInvestmentProfileUseCase.calculateProfile(customer);

        OptIn optIn = createOptIn(customer);

        ExecutorService sendOptInExecutorService = Executors.newCachedThreadPool();

        sendOptInExecutorService.submit(() -> sendOptInUseCase.send(optIn));

        return saveCustomerUseCase.save(customer);
    }

    private OptIn createOptIn(Customer customer){
        return OptIn.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber("+" + customer.getPhoneNumber().toString())
                .build();
    }

}
