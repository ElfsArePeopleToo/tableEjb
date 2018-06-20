package ejb.beans.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ejb.beans.enums.OrderStatus;


import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
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
