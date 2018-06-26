package ejb.beans;

import ejb.beans.model.DriverJson;
import ejb.beans.model.OrderJson;
import ejb.beans.model.WaggonJson;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
public class UpdateBean implements Serializable {
    @Inject
    @Push(channel = "update")
    private PushContext push;

    private DriverJson driverJson;

    private OrderJson orderJson;

    private WaggonJson waggonJson;

    public void loadUpdateWaggons(@Observes String waggonJson){
        push.send(waggonJson);
    }

    public void loadUpdateDrivers(@Observes String driverJson){
        push.send(driverJson);
    }

    public void loadUpdateOrders(@Observes String orderJson){
        push.send(orderJson);
    }


}
