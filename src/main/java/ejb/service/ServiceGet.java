package ejb.service;

import ejb.beans.model.GetResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


@Singleton
public class ServiceGet {
    private static final String REST_URI = "http://localhost:8080/getJson";
    private Client client = ClientBuilder.newClient();

    public GetResponse getJsonResponse(){
        System.out.println("I'm here");
        return client
                .target(REST_URI)
                .request()
                .get(GetResponse.class);
    }
}
