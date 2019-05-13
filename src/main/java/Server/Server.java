package Server;

import Core.UserData.Controller;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;


public class Server {
    //port # and URI for the server
    public static final int PORT = 1337;
    public static final String URI = "http://0.0.0.0/";

    //Packages that contain the resource classes
    public static final String [] RESOURCE_PACKAGES = {"Server.Resources"};

    public static HttpServer startServer(){
        URI baseUri = UriBuilder.fromUri(URI).port(PORT).build();
        final ResourceConfig config = new ResourceConfig().packages(RESOURCE_PACKAGES);

        return GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

    public static void main(String[] args){
        startServer();
        Controller.createGame();
    }

}
