package Server.Resources;

import UserData.Controller;
import UserData.User;
import UserData.UserList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.io.InvalidObjectException;

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

    @POST
    public void createNewUser(String username){
        User newUser;
        try{
            newUser = new User(username);
            Controller.userList.addUser(newUser);
        } catch (Exception e) {
            System.out.println("You have done something wrong.");
        }
    }




}
