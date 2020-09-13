package hackathon.banco.safra.easyway.application.ports.in.score;

import hackathon.banco.safra.easyway.application.domain.score.Score;

public interface CheckScoreUseCase {

    Score check(String cpf);
}
