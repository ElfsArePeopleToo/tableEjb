package ejb.controllers;


import ejb.beans.HelloEjb;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import java.io.Serializable;

@Named("hello")
@SessionScoped
public class Hello implements Serializable {

    @EJB
    private HelloEjb helloEjb;

    private String message;

    public void setName(String name) {
        message = helloEjb.sayHello(name);
    }

    public String getMessage() {
        return message;
    }

}
