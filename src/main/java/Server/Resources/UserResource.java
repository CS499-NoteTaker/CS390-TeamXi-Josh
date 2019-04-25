package Server.Resources;

import UserData.UserList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("user")
public class UserResource {

    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/user.html");}

    private UserList users = new UserList();

    @GET
    @Path("{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("username") String username){
        return users.getUserByUsername(username).toString();
    }



}
