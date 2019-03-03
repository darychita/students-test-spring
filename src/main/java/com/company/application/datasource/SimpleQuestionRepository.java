package com.company.application.datasource;

import com.company.application.utils.QuestionCSVConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import domain.model.data.Question;
import domain.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SimpleQuestionRepository implements QuestionRepository {

    private String fileUrl;

    @Autowired
    public SimpleQuestionRepository(@Value("${questions.url}") String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public Question find(int index) {
        return findAll().get(index);
    }

    @Override
    public List<Question> findAll() {
        try {
            List<QuestionCSVEntity> questionCSVEntities =  new CsvToBeanBuilder<QuestionCSVEntity>(
                    new FileReader(this.fileUrl))
                    .withType(QuestionCSVEntity.class)
                    .build()
                    .parse();

            return questionCSVEntities.stream()
                    .map(QuestionCSVConverter::covertToQuestion)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
