package hackathon.banco.safra.easyway.adapters.persistence.mapper.optin;

import hackathon.banco.safra.easyway.adapters.persistence.entity.optin.OptInEntity;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import org.springframework.stereotype.Component;

@Component
public class OptInPersistenceMapper {

    public OptInEntity mapToEntity(OptIn optIn){
        return OptInEntity.builder()
                .name(optIn.getName())
                .email(optIn.getEmail())
                .phoneNumber(optIn.getPhoneNumber())
                .build();
    }

    public OptIn mapToDomain(OptInEntity optInEntity){
        return OptIn.builder()
                .name(optInEntity.getName())
                .email(optInEntity.getEmail())
                .phoneNumber(optInEntity.getPhoneNumber())
                .build();
    }
}
