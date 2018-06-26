package ejb.beans.model;

import java.io.Serializable;

public class GetResponse implements Serializable {
    private String answer;

    public GetResponse(){

    }

    public GetResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "GetResponse{" +
                "answer='" + answer + '\'' +
                '}';
    }
}
