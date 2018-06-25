//package ejb.beans.model;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//
//import java.io.IOException;
//
//public class DeserializerDriver extends StdDeserializer<DriverJson> {
//
//public DeserializerDriver() {
//        this(null);
//        }
//
//protected DeserializerDriver(Class<?> vc) {
//        super(vc);
//        }
//
//public DriverJson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//
//        }
//        }