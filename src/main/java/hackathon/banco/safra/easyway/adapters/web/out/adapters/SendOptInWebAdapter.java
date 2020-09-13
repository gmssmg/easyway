package hackathon.banco.safra.easyway.adapters.web.out.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.banco.safra.easyway.adapters.web.out.dto.OptInOutputDto;
import hackathon.banco.safra.easyway.adapters.web.out.mapper.OptInOutputWebMapper;
import hackathon.banco.safra.easyway.application.domain.authentication.TokenResponseModel;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import hackathon.banco.safra.easyway.application.ports.in.authentication.GenerateTokenUseCase;
import hackathon.banco.safra.easyway.application.ports.out.optin.SendOptInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class SendOptInWebAdapter implements SendOptInPort {

    @Value("${safra.optin.uri}")
    private String optInUri;

    private final RestTemplate restTemplate;

    private final GenerateTokenUseCase generateTokenUseCase;

    private final OptInOutputWebMapper mapper;
    
    @Override
    public OptIn send(OptIn optIn) throws JsonProcessingException {

        OptInOutputDto optInOutputDto = mapper.mapToDto(optIn);

        ResponseEntity<TokenResponseModel> tokenResponseModelResponseEntity = generateTokenUseCase.generateToken();

        TokenResponseModel tokenResponseModel = tokenResponseModelResponseEntity.getBody();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(tokenResponseModel.getAccessToken());

        ObjectMapper objectMapper = new ObjectMapper();

        String body = objectMapper.writeValueAsString(optInOutputDto);

        HttpEntity<?> request = new HttpEntity<>(body, headers);


        restTemplate.postForEntity(optInUri, request, String.class);

        return optIn;
    }

}
