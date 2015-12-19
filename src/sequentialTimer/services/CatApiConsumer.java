package sequentialTimer.services;

import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Consumer class written to interact with the Cap API RESTful service.
 */
public class CatApiConsumer {

    final static Logger logger = Logger.getLogger(CatApiConsumer.class);

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
    public void setReturnedKitten(String returnedKitten) {
        this.returnedKitten = returnedKitten;
    }

    /**
     * Get method for the return of the REST call. It will return a stored value, or call the service if no
     * value is stored.
     * @return  an adorable kitten image
     */
    public String getReturnedKitten() {

        if (returnedKitten == null) {
            runKittenService();
        }
        return returnedKitten;
    }

    /**
     * Method that calls the Cap API RESTful service. Using the provided URL and my API key (freely requestable from
     * the service provider), to which parameters for return format and image size are appended, the serbive is called
     * and a kitten image is requested. The return value is saved to the returnedKitten class variable.
     *
     * The API has several other parameters that can be used, including image type (jpg, gif, etc) and categories
     * (kitten, box, etc), though categories didn't work when I tried it. Using the API key gives access to a larger
     * library of images.
     */
    public void runKittenService() {
        client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_SERVICE_URL);
        target = target.path("get").queryParam("api_key", "NTMwNTc").queryParam("format", "html").queryParam("size", "lg");
        returnedKitten = target.request(MediaType.TEXT_HTML).get(String.class);
        logger.info("A new kitten has been retrieved!");
    }
}
