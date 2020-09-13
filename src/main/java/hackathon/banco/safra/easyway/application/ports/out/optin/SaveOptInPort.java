package hackathon.banco.safra.easyway.application.ports.out.optin;

import hackathon.banco.safra.easyway.application.domain.optin.OptIn;

public interface SaveOptInPort {

    OptIn save(OptIn optIn);
}
