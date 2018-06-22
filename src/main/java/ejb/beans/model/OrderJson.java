package ejb.beans.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import javax.ejb.Stateless;
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

    public Integer getRegNumberOrder() {
        return regNumberOrder;
    }

    public List<String> getWayPoints() {
        return wayPoints;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setRegNumberOrder(Integer regNumberOrder) {
        this.regNumberOrder = regNumberOrder;
    }

    public void setWayPoints(List<String> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
