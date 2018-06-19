package ejb.beans;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class DeserializerOrders extends StdDeserializer<OrderJson> {

    public DeserializerOrders() {
        this(null);
    }

    protected DeserializerOrders(Class<?> vc) {
        super(vc);
    }

    public OrderJson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String text = node.get("text").asText();
        return new OrderJson(text);
    }
}
