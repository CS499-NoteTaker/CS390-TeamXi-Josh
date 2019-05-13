package Server.Resources;


import Core.UserData.*;

import javax.ws.rs.*;
import java.io.InputStream;




@Path("welcome")
public class WelcomeResource {

    public static User currentUser;


    public WelcomeResource() {

    }


    @GET
    public InputStream getClient() {
        return this.getClass().getResourceAsStream("/welcome.html");
    }

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getClientJavascript(@PathParam("file") String fileName) {
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if (stream == null) {
            throw new WebApplicationException(404);
        }
        return stream;
    }


    /**
     * This creates a new user. But does not add if the user
     * name already exists
     *
     * @param userName - string userName
     * @return - int: Web application code
     */
    @POST
    @Path("/createNewUser")
    public int createNewUser(String userName) {
        userName = userName.trim();

        if (userName.length() == 0) {
            System.out.println("You didn't put anything in the username field.");
            return 406;

        } else if (Controller.userList.contains(userName)) {
            System.out.print("User " + userName + " already exists.");
            return 407;
        }

        User newUser = new User(userName);
        Controller.userList.addUser(newUser);

        return 200;
    }




    @POST
    @Path("/login")
    public int login(String userName) {
        userName = userName.trim();

        if (userName.length() == 0) {
            System.out.println("You didn't put anything in the username field.");
            return 406;

        } else if ( !Controller.userList.contains( userName ) ) {
            System.out.println("This is not a user in the registry.");
            return 407;
        }


        currentUser = Controller.userList.getUserByUsername( userName );
        return 200;
    }



}
