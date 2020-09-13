package hackathon.banco.safra.easyway.application.service.score;

import hackathon.banco.safra.easyway.application.domain.score.Score;
import hackathon.banco.safra.easyway.application.ports.in.score.CheckScoreUseCase;
import hackathon.banco.safra.easyway.application.ports.out.score.CheckScorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckScoreService implements CheckScoreUseCase {

    private final CheckScorePort checkScorePort;

    @Override
    public Score check(String cpf) {
        return checkScorePort.check(cpf);
    }

}
