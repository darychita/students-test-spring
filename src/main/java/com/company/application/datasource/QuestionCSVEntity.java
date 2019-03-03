package com.company.application.datasource;

import com.company.application.utils.AnswerCSVConverter;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import domain.model.data.Answer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionCSVEntity {

    @CsvBindByName(column = "number")
    private Integer number;

    @CsvBindByName(column = "questionText")
    private String questionText;

    @CsvBindAndSplitByName(column = "answers", elementType = Answer.class,
            splitOn = "\\|", converter = AnswerCSVConverter.class)
    private List<Answer> answers = new ArrayList<>();

    @CsvBindByName(column = "correctAnswer")
    private String correctAnswer;


}
