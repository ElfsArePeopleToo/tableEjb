package ejb.beans;

import javax.ejb.Stateful;

@Stateful
public class HelloEjb {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
