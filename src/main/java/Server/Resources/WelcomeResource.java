package Server.Resources;

import UserData.Controller;
import UserData.User;

import javax.naming.ldap.Control;
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
    public int createNewUser(String userName) {
        userName = userName.trim();

        if (userName.length() == 0) {
            System.out.println("There no user name inputed");
            return 406;

        } else if (Controller.userList.contains(userName)) {
            System.out.print("Already contains user name:" + userName);
            return 406;
        }

        User newUser = new User(userName);
        Controller.userList.addUser(newUser);

        return 200;
    }




    @POST
    public int logIn(String userName) {
        userName = userName.trim();

        if (userName.length() == 0) {
            System.out.println("There no user name inputed");
            return 406;

        } else if ( !Controller.userList.contains( userName ) ) {
            System.out.println("This user name does not exist.");
            return 406;
        }


        currentUser = Controller.userList.getUserByUsername( userName );
        return 200;
    }



}
