package com.company.application.utils;

import com.opencsv.bean.AbstractCsvConverter;
import domain.model.data.Answer;

public class AnswerCSVConverter extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String value)  {
        Answer answer = new Answer();
        String[] text = value.split("\\.");
        answer.setPoint(
                String.valueOf(text[0].charAt(0)));
        answer.setAnswerText(text[1]);

        return answer;
    }
}
