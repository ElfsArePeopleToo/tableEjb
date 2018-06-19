package ejb.beans;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Stateless
public class Consumer {


    private OrderJson orderJson;

    private final static String QUEUE_NAME = "ordersQueue";

    public void receive(){
    try {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
//                String message = new String(body, "UTF-8");
                ObjectMapper mapper = new ObjectMapper();
                orderJson = mapper.readValue(body, OrderJson.class);
                System.out.println("Received '" + orderJson + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }catch(IOException e){
        e.printStackTrace();
    }catch (TimeoutException e){
        e.printStackTrace();
    }
}

    public Consumer(){
    }


}

