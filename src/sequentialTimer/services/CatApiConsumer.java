package sequentialTimer.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Student on 12/7/2015.
 */
public class CatApiConsumer {

    private Client client;
    private String REST_SERVICE_URL = "http://thecatapi.com/api/images"; //?api_key=NTMwNTc&format=html
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

        if (returnedKitten == null) {
            runKittenService();
        }
        return returnedKitten;
    }

    public void setReturnedKitten(String returnedKitten) {
        this.returnedKitten = returnedKitten;
    }


    public void runKittenService() {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_SERVICE_URL);
        target = target.path("get").queryParam("api_key", "NTMwNTc").queryParam("format", "html").queryParam("size", "lg");
        returnedKitten = target.request(MediaType.TEXT_HTML).get(String.class);
    }
}
