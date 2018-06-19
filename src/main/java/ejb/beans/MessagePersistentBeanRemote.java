package ejb.beans;

import javax.ejb.Stateless;

@Stateless
public class MessagePersistentBeanRemote {
    private String message;

    public MessagePersistentBeanRemote() {
    }

    public MessagePersistentBeanRemote(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessagePersistentBeanRemote{" +
                "message='" + message + '\'' +
                '}';
    }
}
