package ejb.beans.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;
import java.util.List;

//@JsonDeserialize(using = DeserializerOrders.class)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderJson implements Serializable {

    private Integer regNumberOrder;
    private List<String> wayPoints;
    private String regNumber;
    private List<String> drivers;
    private String orderStatus;

}
