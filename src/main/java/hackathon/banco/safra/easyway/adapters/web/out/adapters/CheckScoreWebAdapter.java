package hackathon.banco.safra.easyway.adapters.web.out.adapters;

import hackathon.banco.safra.easyway.application.domain.score.Score;
import hackathon.banco.safra.easyway.application.ports.out.score.CheckScorePort;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class CheckScoreWebAdapter implements CheckScorePort {

    @Override
    public Score check(String cpf) {
        Score score = new Score();

        int calculatedScore = ThreadLocalRandom.current().nextInt(0, 1000);

        score.setScoreGrade(calculatedScore);

        return score;
    }
}
