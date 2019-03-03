package com.company.application.presentation;

import domain.application.EvaluatingResultService;
import domain.business.QuestionService;
import domain.business.StudentService;
import domain.model.data.Answer;
import domain.model.data.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class TestRunner {

    private EvaluatingResultService evaluatingResultService;
    private StudentService studentService;
    private QuestionService questionsService;

    @Autowired
    public TestRunner(EvaluatingResultService evaluatingResultService, StudentService studentService, QuestionService questionsService) {
        this.evaluatingResultService = evaluatingResultService;
        this.studentService = studentService;
        this.questionsService = questionsService;
    }

    public void runTest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Please introduce yourself");
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        studentService.getByName(name);
        System.out.println("Have a nice testing, " + name + " !");

        List<String> rawAnswers = new ArrayList<>(5);
        questionsService.getAllQuestions()
                .forEach(question -> {
                    this.printQuestionText(question);
                    this.printAllAnswers(question.getAnswers());
                    System.out.println("Your answer: ");
                    rawAnswers.add(scanner.nextLine());
                });

        int rating = evaluatingResultService.evaluateResult(rawAnswers);

        System.out.println("You score is " + rating + " of " + rawAnswers.size() + ", " + name);

    }

    private void printQuestionText(Question question){
        System.out.println(question.getNumber() + " " + question.getQuestionText());
    }

    private void printAllAnswers(List<Answer> answers){
        answers.forEach(System.out::println);
    }
}
