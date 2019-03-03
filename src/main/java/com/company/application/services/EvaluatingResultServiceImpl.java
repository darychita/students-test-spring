package com.company.application.services;

import domain.application.EvaluatingResultService;
import domain.business.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EvaluatingResultServiceImpl implements EvaluatingResultService {

    private QuestionService questionsService;

    @Autowired
    public EvaluatingResultServiceImpl(QuestionService questionService) {
        this.questionsService = questionService;
    }

    @Override
    public int evaluateResult(List<String> rawAnswers) {
        int rating = 0;

        if(questionsService.getRightAnswers().size() != rawAnswers.size()){
            throw new RuntimeException("Ooops... Something went wrong with getting answers");
        }

        Iterator<String> rawAnswersIterator = rawAnswers.iterator();
        Iterator<String> rightAnswersIterator = questionsService.getRightAnswers().iterator();

        while (rawAnswersIterator.hasNext() && rightAnswersIterator.hasNext()){

            String rawAnswer = rawAnswersIterator.next().trim();
            String rightAnswer = rightAnswersIterator.next().trim();

            if(rawAnswer.equalsIgnoreCase(rightAnswer)){
                rating++;
            }
        }
        return rating;
    }
}
