package hackathon.banco.safra.easyway.application.service.optin;

import com.fasterxml.jackson.core.JsonProcessingException;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import hackathon.banco.safra.easyway.application.ports.in.optin.SaveOptInUseCase;
import hackathon.banco.safra.easyway.application.ports.in.optin.SendOptInUseCase;
import hackathon.banco.safra.easyway.application.ports.out.optin.SendOptInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendOptInService implements SendOptInUseCase {

    private final SaveOptInUseCase saveOptInUseCase;
    private final SendOptInPort sendOptInPort;

    @Override
    public OptIn send(OptIn optIn) throws JsonProcessingException {
         sendOptInPort.send(optIn);
         return saveOptInUseCase.save(optIn);
    }

}
