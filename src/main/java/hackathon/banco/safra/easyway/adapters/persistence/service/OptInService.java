package hackathon.banco.safra.easyway.adapters.persistence.service;

import hackathon.banco.safra.easyway.adapters.persistence.entity.optin.OptInEntity;
import hackathon.banco.safra.easyway.adapters.persistence.repository.OptInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptInService {

    private final OptInRepository repository;

    public OptInEntity save(OptInEntity optInEntity){
        return repository.saveAndFlush(optInEntity);
    }
}
