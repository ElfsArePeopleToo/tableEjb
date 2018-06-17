package ejb.beans;

import javax.ejb.Stateful;

@Stateful
public class helloEjb {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
