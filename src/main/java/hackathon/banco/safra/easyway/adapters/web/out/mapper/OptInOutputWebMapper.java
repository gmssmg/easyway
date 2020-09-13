package hackathon.banco.safra.easyway.adapters.web.out.mapper;

import hackathon.banco.safra.easyway.adapters.web.out.dto.OptInOutputDto;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import org.springframework.stereotype.Component;

@Component
public class OptInOutputWebMapper {

    public OptInOutputDto mapToDto(OptIn optIn){
        return OptInOutputDto.builder()
                .name(optIn.getName())
                .email(optIn.getEmail())
                .phoneNumber(optIn.getPhoneNumber())
                .build();
    }
}
