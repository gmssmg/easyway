package hackathon.banco.safra.easyway.adapters.web.out.adapters;

import hackathon.banco.safra.easyway.application.domain.authentication.TokenResponseModel;
import hackathon.banco.safra.easyway.application.ports.out.authentication.GenerateTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
@RequiredArgsConstructor
public class GenerateTokenWebAdapter implements GenerateTokenPort {

    private final RestTemplate restTemplate;

    @Value("${safra.token.uri}")
    private String tokenUri;

    @Value("${api.client.id}")
    private String clientId;

    @Value("${api.client.secret}")
    private String clientSecret;

    @Override
    public ResponseEntity<TokenResponseModel> generateToken() {

        try{
            String accessKey = clientId + ":" + clientSecret;

            String encodedAccessKey = Base64.getEncoder().encodeToString(accessKey.getBytes());

            String authorization = "Basic " + encodedAccessKey;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("authorization", authorization);

            String body = "grant_type=client_credentials&scope=urn:opc:resource:consumer::all";

            HttpEntity<?> request = new HttpEntity<>(body, headers);

            return restTemplate.postForEntity(tokenUri, request, TokenResponseModel.class);
        } catch (HttpClientErrorException | HttpServerErrorException e){
            e.printStackTrace();
        }

        return null;
    }

}
