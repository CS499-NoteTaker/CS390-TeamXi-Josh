
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ResourceTests {
    private static final String HOST_URI = "http://localhost:1337/";
    private static HttpServer server;
    private static Client client;

    @BeforeClass
    public static void startServer(){
        server = Server.Server.startServer();
        client = ClientBuilder.newClient();
    }

    @AfterClass
    public static void stopServer(){
        if(client != null) client.close();
        if(server != null) server.shutdown();
    }

    @Test
    public void test(){
        Assert.assertEquals(true, true);
    }
    }

