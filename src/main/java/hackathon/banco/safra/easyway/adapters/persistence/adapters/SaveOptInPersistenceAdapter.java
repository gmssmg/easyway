package hackathon.banco.safra.easyway.adapters.persistence.adapters;

import hackathon.banco.safra.easyway.adapters.persistence.entity.optin.OptInEntity;
import hackathon.banco.safra.easyway.adapters.persistence.mapper.optin.OptInPersistenceMapper;
import hackathon.banco.safra.easyway.adapters.persistence.service.OptInService;
import hackathon.banco.safra.easyway.application.domain.optin.OptIn;
import hackathon.banco.safra.easyway.application.ports.out.optin.SaveOptInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOptInPersistenceAdapter implements SaveOptInPort {

    private final OptInPersistenceMapper mapper;
    private final OptInService service;

    @Override
    public OptIn save(OptIn optIn) {
        OptInEntity optInEntity = mapper.mapToEntity(optIn);
        OptInEntity savedOptInEntity = service.save(optInEntity);
        return mapper.mapToDomain(savedOptInEntity);
    }

}
