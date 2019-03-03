package domain.model.data;

import lombok.Data;

@Data
public class Answer {

    private String point;
    private String answerText;

    @Override
    public String toString(){
        return "\t" + this.point + ". " + this.answerText;
    }

}
