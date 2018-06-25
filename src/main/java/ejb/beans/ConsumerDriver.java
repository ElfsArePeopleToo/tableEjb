package ejb.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import ejb.beans.model.DriverJson;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Stateless
public class ConsumerDriver {
    private DriverJson driverJson;

    public DriverJson receive(String QueueName){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            final Connection connection = factory.newConnection();

            final Channel channel = connection.createChannel();
            channel.queueDeclare(QueueName, true, false, false, null);
            final com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {

                    String message = new String(body, "UTF-8");
                    System.out.println(message);
                    ObjectMapper mapper = new ObjectMapper();
                    driverJson = mapper.readValue(body, DriverJson.class);
                    System.out.println("Received '" + driverJson + "'");
                }
            };

            channel.basicConsume(QueueName, true, consumer);
        }catch(IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return driverJson;
    }
    public ConsumerDriver(){
    }
}
