package ejb.controllers;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("hello")
@SessionScoped
public class Hello implements Serializable {

    @EJB
    private Hello helloEjb;

    private String message;

    public void setName(String name) {
        message = helloEjb.sayHello(String name);
    }

    public String getMessage() {
        return message;
    }

}
