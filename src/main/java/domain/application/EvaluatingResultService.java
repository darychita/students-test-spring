package domain.application;

import java.util.List;

public interface EvaluatingResultService {

    int evaluateResult(List<String> rawAnswers);
}
