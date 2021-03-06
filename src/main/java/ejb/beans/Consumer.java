package ejb.beans;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import ejb.beans.model.OrderJson;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
@Slf4j
@NoArgsConstructor
@Stateless
public class Consumer {
    private List<OrderJson> orders = new ArrayList<OrderJson>();
    private Connection connection;

    @Inject
    private BeanManager beanManager;

    public List<OrderJson> receive(String QueueName){
    try {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();

        final Channel channel = connection.createChannel();
        channel.queueDeclare(QueueName, true, false, false, null);
        final com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

//                    String message = new String(body, "UTF-8");
//                    System.out.println(message);
                    ObjectMapper mapper = new ObjectMapper();
                    OrderJson orderJson = mapper.readValue(body, OrderJson.class);
                    orders.add(orderJson);
                    beanManager.fireEvent(orderJson);

//                    System.out.println("Received '" + orderJson + "'");
            }
        };
        channel.basicConsume(QueueName, true, consumer);
    }catch(IOException e) {
        log.error("Connection fail.");
    } catch (TimeoutException e) {
       log.error("Connection is timeout.");
    }
        return orders;
}

    @PreDestroy
    public void close(){
        try{
            connection.close();
        } catch (IOException e) {
            log.error("Connection fail.");
        }
}

}

