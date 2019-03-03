package com.company.application.services;

import domain.business.QuestionService;
import domain.model.data.Question;
import domain.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseQuestionService implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public BaseQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<String> getRightAnswers() {
        return  getAllQuestions().stream()
                .map(Question::getCorrectAnswer)
                .collect(Collectors.toList());
    }
}
