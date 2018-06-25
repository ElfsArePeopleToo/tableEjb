package ejb.controllers;

import ejb.beans.Consumer;
import ejb.beans.ConsumerDriver;
import ejb.beans.model.ConsumerWaggon;
import ejb.beans.model.DriverJson;
import ejb.beans.model.OrderJson;
import ejb.beans.model.WaggonJson;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("loadInfo")
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
