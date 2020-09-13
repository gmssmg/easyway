package hackathon.banco.safra.easyway.application.ports.out.score;

import hackathon.banco.safra.easyway.application.domain.score.Score;

public interface CheckScorePort {

    Score check(String cpf);
}
