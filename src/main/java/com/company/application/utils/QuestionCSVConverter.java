package com.company.application.utils;

import com.company.application.datasource.QuestionCSVEntity;
import domain.model.data.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionCSVConverter {

    public static Question covertToQuestion(QuestionCSVEntity object) {
        Question question = new Question();

        question.setNumber(object.getNumber());
        question.setQuestionText(object.getQuestionText());
        question.setAnswers(object.getAnswers());
        question.setCorrectAnswer(object.getCorrectAnswer());

        return question;
    }
}
