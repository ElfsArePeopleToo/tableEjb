package ejb.beans.model;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class WaggonJson implements Serializable {
    private int allWaggonsCount;
    private int freeWaggonsCount;
    private int busyWaggonsCount;
    private int workingWaggonCount;
    private int brokenWaggonCount;

}

