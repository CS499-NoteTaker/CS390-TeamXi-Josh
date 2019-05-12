package Server.Resources;


import Core.GameLogic.Game;
import Core.UserData.Controller;
import Core.UserData.User;
import com.google.gson.Gson;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.Scanner;

@Singleton
@Path("game")
public class GameResource {

    // Fields
    // Now referring to Controller.games static variable


    public GameResource() {
        //Controller.gameList.addGameToList( new Game( new User("Josh"), new User("Daniel")) );
    }



    //Todo: Uncomment next two lines
//    @GET
//    public InputStream getClient() {return this.getClass().getResourceAsStream("/GameResource.html");}

    //Get List of all games
    @GET
    public String getAllGames() {
        Gson gson = new Gson();
        return gson.toJson( Controller.gameList );
    }


    //Todo this does so by retrieving string, has not tried aaccepting json object
    /**
     * This will help to create game with user1 and user 2
     * @param twoUsers - twoUsers separated by a white space
     * @return - returns 200 if successful
     */
    @POST
    public int createGame(String twoUsers) {
        Scanner scan = new Scanner(twoUsers);

        // Checks to see if there have been an input of two users
        if( !hasTwoUsers( twoUsers ) ) { throw new WebApplicationException(406); }

        // Separates the input
        String user1Name = scan.next();
        String user2Name = scan.next();

        // Creates two users for a game
        User user1;
        User user2;

        // Assigning the current user.
        user1 = WelcomeResource.currentUser;


        
        user2 = Controller.userList.getUserByUsername( user2Name );

        // Checks to see if user2Name has been found in UserList
        if( user2 == null ) {
            System.out.println("User 2 not found ");
            return 500;
        }


        // Creates new game with two users
        Game newGame = new Game( user1, user2 );
        Controller.gameList.addGameToList( newGame );
        
        return 200;
    }




    private boolean hasTwoUsers( String twoUsers ) {
        // Removes whitespaces at the end
        twoUsers = twoUsers.trim();
        Scanner scan = new Scanner(twoUsers);

        int counter = 0;

        while ( scan.hasNext() ) {
            counter++;
            scan.next();
        }

        // checks to if there were two Strings
        if( counter == 2 )
            return true;
        else
            return false;

    }


}
