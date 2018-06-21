package ejb.controllers;


import com.sun.org.apache.xpath.internal.operations.Or;
import ejb.beans.Consumer;
import ejb.beans.HelloEjb;
import ejb.beans.model.OrderJson;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("hello")
@SessionScoped
public class Hello implements Serializable {

    @EJB
    private HelloEjb helloEjb;
    @EJB
    private Consumer consumer;

    private String message;

    public void setName(String name) {
        message = helloEjb.sayHello(name);
        List<OrderJson> orders = consumer.receive();
    }

    public String getMessage() {
        return message;
    }

}
