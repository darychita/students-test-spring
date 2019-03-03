package domain.model.repository;

import domain.model.data.Question;

import java.util.List;

public interface QuestionRepository {

    Question find(int index);
    List<Question> findAll();
}
