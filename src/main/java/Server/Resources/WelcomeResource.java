package Server.Resources;

import UserData.User;

import javax.ws.rs.*;
import java.io.InputStream;




@Path("welcome")
public class WelcomeResource {

    private User currentUser;


    public WelcomeResource() {
        
    }





    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/welcome.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getClientJavascript(@PathParam("file") String fileName){
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if(stream == null){
            throw new WebApplicationException(404);
        }
        return stream;
    }





}
