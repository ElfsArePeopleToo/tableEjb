package ejb.beans;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import ejb.beans.model.OrderJson;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Stateless
public class Consumer {


    private OrderJson orderJson;

    private final static String QUEUE_NAME = "ordersQueue";

    private List<OrderJson> orders = new ArrayList<OrderJson>();

    public List<OrderJson> receive(){
    try {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();

        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        final com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {

                    String message = new String(body, "UTF-8");
                    System.out.println(message);
                    ObjectMapper mapper = new ObjectMapper();
                OrderJson orderJson = mapper.readValue(body, OrderJson.class);
                orders.add(orderJson);
//                    System.out.println("Received '" + orderJson + "'");

            }

        };
        channel.basicConsume(QUEUE_NAME, true, consumer);


    }catch(IOException e) {
        e.printStackTrace();
    } catch (TimeoutException e) {
        e.printStackTrace();
    }
        return orders;
}

    public Consumer(){
    }
}

