package Server.Resources;

import Core.UserData.Controller;
import Core.UserData.User;
import Core.UserData.UserList;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("user")
public class UserResource {

    private UserList users = new UserList();

    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/user.html");}

    /**
     * Takes a username and returns the user as a Json object if found in the Controller userList
     * @param username - username of the requested user
     * @return Json object of the user, if found, null otherwise
     */
    @GET
    @Path("{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("username") String username){
        try {
            User user;
            user = Controller.userList.getUserByUsername(username);
            Gson gson = new Gson();
            return gson.toJson(user);
        } catch (Exception e){
            throw new WebApplicationException(350);
        }
    }

    /**
     * Takes a username and creates a new user and adds it to the Controller userList
     * @param username - username of the new user
     */
    @POST
    public void createNewUser(String username){
        User newUser;
        try{
            newUser = new User(username);
            Controller.userList.addUser(newUser);
        } catch (Exception e) {
            throw new WebApplicationException(350);
        }
    }


}
