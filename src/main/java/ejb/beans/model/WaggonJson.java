package ejb.beans.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
//@JsonDeserialize(using = DeserializerOrders.class)
public class WaggonJson implements Serializable {
    private int allWaggonsCount;
    private int freeWaggonsCount;
    private int busyWaggonsCount;
    private int workingWaggonCount;
    private int brokenWaggonCount;

}

