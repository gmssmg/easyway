package hackathon.banco.safra.easyway.application.ports.in.optin;

import hackathon.banco.safra.easyway.application.domain.optin.OptIn;

public interface SaveOptInUseCase {

    OptIn save(OptIn optIn);
}
