package hackathon.banco.safra.easyway.application.ports.in.optin;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;

public interface SendOptInUseCase {

    OptIn send(OptIn optIn) throws JsonProcessingException;
}
