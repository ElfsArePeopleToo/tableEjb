package ejb.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import ejb.beans.model.DriverJson;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
@NoArgsConstructor
@Stateless
public class ConsumerDriver {
    private DriverJson driverJson;
    private Connection connection;
    private Channel channel;

    @Inject
    private BeanManager beanManager;

    public DriverJson receive(String QueueName){
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

                    ObjectMapper mapper = new ObjectMapper();
                    driverJson = mapper.readValue(body, DriverJson.class);
                    log.info(String.valueOf(driverJson));

                }
            };
            channel.basicConsume(QueueName, true, consumer);
        }catch(IOException e) {
            log.error("Connection fail.");
        } catch (TimeoutException e) {
            log.error("Connection is timeout.");
        }
        return driverJson;
    }


}
