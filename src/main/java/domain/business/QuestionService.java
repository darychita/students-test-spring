package domain.business;

import domain.model.data.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();
    List<String> getRightAnswers();
}
