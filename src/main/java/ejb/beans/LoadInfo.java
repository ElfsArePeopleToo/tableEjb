package ejb.beans;

import ejb.beans.Consumer;
import ejb.beans.ConsumerDriver;
import ejb.beans.ConsumerWaggon;
import ejb.beans.model.DriverJson;
import ejb.beans.model.OrderJson;
import ejb.beans.model.WaggonJson;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("loadInfo")
@Data
@SessionScoped
public class LoadInfo implements Serializable {
    @EJB
    Consumer consumer;

    @EJB
    ConsumerDriver consumerDriver;

    @EJB
    ConsumerWaggon consumerWaggon;

    public List<OrderJson> getInfo(){
        List<OrderJson> orders = consumer.receive("ordersQueue");
        return orders;
    }

    public DriverJson getInfoDriver(){
       DriverJson driverJson = consumerDriver.receive("drivers");
       return  driverJson;
    }

    public WaggonJson getInfoWaggon(){
        WaggonJson waggonJson = consumerWaggon.receive("waggons");
        return  waggonJson;
    }
}
