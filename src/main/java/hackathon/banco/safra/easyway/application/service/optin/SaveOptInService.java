package hackathon.banco.safra.easyway.application.service.optin;

import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import hackathon.banco.safra.easyway.application.ports.in.optin.SaveOptInUseCase;
import hackathon.banco.safra.easyway.application.ports.out.optin.SaveOptInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOptInService implements SaveOptInUseCase {

    private final SaveOptInPort saveOptInPort;


    @Override
    public OptIn save(OptIn optIn) {
        return saveOptInPort.save(optIn);
    }
}
