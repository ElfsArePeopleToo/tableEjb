package ejb.beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.io.Serializable;


//@JsonDeserialize(using = DeserializerOrders.class)
public class OrderJson implements Serializable {

    private String text;

    public OrderJson(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "text='" + text + '\'' +
                '}';
    }
}
