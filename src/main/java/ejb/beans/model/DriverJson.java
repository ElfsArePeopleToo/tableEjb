package ejb.beans.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class DriverJson implements Serializable {

    private int driversCount;
    private int freeDriversCount;
    private int busyDriversCount;

}
