//package ejb.beans.model;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import com.fasterxml.jackson.databind.node.IntNode;
//
//import java.io.IOException;
//
//public class DeserializerWaggon extends StdDeserializer<WaggonJson> {
//
//    public DeserializerWaggon() {
//        this(null);
//    }
//
//    protected DeserializerWaggon(Class<?> vc) {
//        super(vc);
//    }
//
//    public WaggonJson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        int allWaggonsCount = (Integer) ((IntNode) node.get("allWaggonsCount")).numberValue();
//        int freeWaggonsCount = (Integer) ((IntNode) node.get("freeWaggonsCount")).numberValue();
//        int busyWaggonsCount = (Integer) ((IntNode) node.get("busyWaggonsCount")).numberValue();
//        int workingWaggonCount = (Integer) ((IntNode) node.get("workingWaggonCount")).numberValue();
//        int brokenWaggonCount = (Integer) ((IntNode) node.get("brokenWaggonCount")).numberValue();
//
//        return new WaggonJson(
//                allWaggonsCount,
//                freeWaggonsCount,
//                busyWaggonsCount,
//                workingWaggonCount,
//                brokenWaggonCount);
//    }
//}
