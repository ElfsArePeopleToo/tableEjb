package ejb.beans;

import ejb.beans.model.OrderJson;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("loadInfo")
@SessionScoped
public class LoadInfo implements Serializable {

    @Inject
    Consumer consumer;

    public List<OrderJson> getInfo(){
        List<OrderJson> orders = consumer.receive();
        return orders;
    }
}
