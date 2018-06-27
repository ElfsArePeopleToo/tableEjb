package ejb.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import ejb.beans.model.WaggonJson;
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
public class ConsumerWaggon {
    private WaggonJson waggonJson;
    private Connection connection;
    private Channel channel;

    @Inject
    private BeanManager beanManager;

    public WaggonJson receive(String QueueName){
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
                    waggonJson = mapper.readValue(body, WaggonJson.class);
                    log.info(String.valueOf(waggonJson));
                }
            };

            channel.basicConsume(QueueName, true, consumer);

        }catch(IOException e) {
            log.error("Connection fail.");
        } catch (TimeoutException e) {
            log.error("Connection is timeout.");
        }
        return waggonJson;
    }

}