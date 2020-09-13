package hackathon.banco.safra.easyway.application.ports.out.authentication;

import hackathon.banco.safra.easyway.application.domain.authentication.TokenResponseModel;
import org.springframework.http.ResponseEntity;

public interface GenerateTokenPort {

    ResponseEntity<TokenResponseModel> generateToken();

}
