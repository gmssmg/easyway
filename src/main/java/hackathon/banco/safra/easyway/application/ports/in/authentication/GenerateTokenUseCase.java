package hackathon.banco.safra.easyway.application.ports.in.authentication;

import hackathon.banco.safra.easyway.application.domain.authentication.TokenResponseModel;
import org.springframework.http.ResponseEntity;


public interface GenerateTokenUseCase {

    ResponseEntity<TokenResponseModel> generateToken();

}
