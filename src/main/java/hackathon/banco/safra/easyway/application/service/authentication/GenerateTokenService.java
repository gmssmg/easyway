package hackathon.banco.safra.easyway.application.service.authentication;

import hackathon.banco.safra.easyway.application.domain.authentication.TokenResponseModel;
import hackathon.banco.safra.easyway.application.ports.in.authentication.GenerateTokenUseCase;
import hackathon.banco.safra.easyway.application.ports.out.authentication.GenerateTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenerateTokenService implements GenerateTokenUseCase {

    private final GenerateTokenPort port;

    @Override
    public ResponseEntity<TokenResponseModel> generateToken() {
        return port.generateToken();
    }

}
