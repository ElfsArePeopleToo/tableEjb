package ejb.beans.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import java.io.Serializable;
import java.util.List;

@JsonDeserialize(using = DeserializerOrders.class)
public class OrderJson implements Serializable {

    private Integer regNumberOrder;
    private List<String> wayPoints;
    private String regNumber;
    private List<String> drivers;
    private String orderStatus;

    public OrderJson(){

    }

    public OrderJson(Integer regNumberOrder, List<String> wayPoints, String regNumber, List<String> drivers, String orderStatus) {
        this.regNumberOrder = regNumberOrder;
        this.wayPoints = wayPoints;
        this.regNumber = regNumber;
        this.drivers = drivers;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "regNumberOrder=" + regNumberOrder +
                ", wayPoints=" + wayPoints +
                ", regNumber=" + regNumber +
                ", drivers=" + drivers +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
