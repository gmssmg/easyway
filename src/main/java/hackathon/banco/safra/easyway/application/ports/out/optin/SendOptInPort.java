package hackathon.banco.safra.easyway.application.ports.out.optin;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;

public interface SendOptInPort {

    OptIn send(OptIn optIn) throws JsonProcessingException;
}
