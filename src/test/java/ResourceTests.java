
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
    public void testGETMenu(){
        String response = client.target(HOST_URI)
                .path("menu")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get(String.class);

        Assert.assertEquals("Welcome to Connect Six!\nWhat would you like to do? (1-3)\n" +
                "1) Play a game!\n2) View the leaderboard!\n3) View your completed game history!\n", response);
    }

    @Test
    public void testGETSecondaryMenu01(){
        String response = client.target(HOST_URI)
                .path("menu/1")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get(String.class);

        Assert.assertEquals("1",response);
    }

    @Test
    public void testGETSecondaryMenu02(){
        String response = client.target(HOST_URI)
                .path("menu/2")
                .request()
                .get(String.class);
        Assert.assertEquals("2",response);
    }

    @Test
    public void testGETSecondaryMenu03(){
        String response = client.target(HOST_URI)
                .path("menu/3")
                .request()
                .get(String.class);
        Assert.assertEquals("3",response);
    }


    @Test(expected = WebApplicationException.class)
    public void testMenu404response() throws WebApplicationException{
        String response = client.target(HOST_URI)
                .path("menu/1/45")
                .request()
                .get(String.class);

        Assert.assertEquals("",response);
    }

    @Test
    public void testGETleaderboard(){
        String response = client.target(HOST_URI)
                .path("leaderboard")
                .request()
                .get(String.class);

        Assert.assertEquals("leaderboard pls" ,response);
    }

    //TODO: Need to fix this test
    /*
    @Test
    public void testGETSpecificGame01(){
        String response = client.target(HOST_URI)
                .path("game/1")
                .request()
                .get(String.class);
        Assert.assertEquals("",response);
    }
    */

}
