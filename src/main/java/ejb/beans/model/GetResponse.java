package ejb.beans.model;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class GetResponse implements Serializable {
    private String answer;
}
