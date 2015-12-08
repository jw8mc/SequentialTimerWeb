package sequentialTimer.services;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Student on 12/7/2015.
 */
public class CatApiConsumer {

    private Client client;
    private String REST_SERVICE_URL = "http://thecatapi.com/api/images/get?api_key=NTMwNTc&format=html&category=kittens&type=jpg,png";
    private String returnedKitten;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getREST_SERVICE_URL() {
        return REST_SERVICE_URL;
    }

    public void setREST_SERVICE_URL(String REST_SERVICE_URL) {
        this.REST_SERVICE_URL = REST_SERVICE_URL;
    }

    public String getReturnedKitten() {
        return returnedKitten;
    }

    public void setReturnedKitten(String returnedKitten) {
        this.returnedKitten = returnedKitten;
    }

    private void init() {
        this.client = ClientBuilder.newClient();
    }

    public void runKittenService() {
        init();
        Response kittenResponse = client.target(REST_SERVICE_URL).request(MediaType.TEXT_HTML).get();
        returnedKitten = kittenResponse.toString();
    }
}
