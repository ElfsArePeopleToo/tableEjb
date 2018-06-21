package ejb.beans.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import ejb.beans.enums.OrderStatus;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DeserializerOrders extends StdDeserializer<OrderJson> {

    public DeserializerOrders() {
        this(null);
    }

    protected DeserializerOrders(Class<?> vc) {
        super(vc);
    }

    public OrderJson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int regNumberOrder = (Integer) ((IntNode) node.get("regNumberOrder")).numberValue();

        JsonNode arrNodeWayPoints = node.get("wayPoints");
        List<String> wayPoints = new ArrayList<String>();
        if (arrNodeWayPoints.isArray()) {
            for (final JsonNode objNode : arrNodeWayPoints) {
                wayPoints.add(objNode.asText());
            }
        }

        String regNumber = node.get("regNumber").asText();

        JsonNode arrNodeDrivers = node.get("drivers");
        List<String> drivers = new ArrayList<String>();
        if (arrNodeDrivers.isArray()) {
            for (final JsonNode objNode : arrNodeDrivers) {
                drivers.add(objNode.asText());
            }
        }
        String orderStatus =  node.get("orderStatus").asText();

        return new OrderJson(regNumberOrder, wayPoints,regNumber ,drivers , orderStatus);
    }
}
