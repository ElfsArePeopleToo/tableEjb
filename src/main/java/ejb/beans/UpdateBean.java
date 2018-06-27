package ejb.beans;

import ejb.beans.model.DriverJson;
import ejb.beans.model.GetResponse;
import ejb.beans.model.OrderJson;
import ejb.beans.model.WaggonJson;
import ejb.controllers.LoadInfo;
import ejb.service.ServiceGet;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Slf4j
@Named
@ApplicationScoped
public class UpdateBean implements Serializable {
    @Inject
    @Push(channel = "update")
    private PushContext push;

    @Inject
    LoadInfo loadInfo;

    public void loadUpdateWaggons(){
       WaggonJson waggonJson= loadInfo.getInfoWaggon();
       log.info(waggonJson.toString());
       push.send(waggonJson);
    }

    public void loadUpdateDrivers(){
        DriverJson driverJson = loadInfo.getInfoDriver();
        log.info(driverJson.toString());
        push.send(driverJson);
    }

    public void loadUpdateOrders()
    {
        List<OrderJson> orderJson = loadInfo.getInfo();
        log.info("orderJson update.");
        push.send(orderJson);

    }


}
