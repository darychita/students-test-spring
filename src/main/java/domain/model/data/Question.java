package domain.model.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Question {

//    @CsvBindByName(column = "number")
    private Integer number;

//    @CsvBindByName(column = "questionText")
    private String questionText;

//    @CsvBindAndSplitByName(column = "answers", elementType = Answer.class,
//            splitOn = "\\|", converter = AnswerConverter.class)
    private List<Answer> answers = new ArrayList<>();

//    @CsvBindByName(column = "correctAnswer")
    private String correctAnswer;

//    public void printQuestionText(){
//        System.out.println(this.number.toString() + ". " + this.questionText);
//    }
//
//    public void printAllAnswer(){
//        this.answers.forEach(System.out::println);
//    }



}
