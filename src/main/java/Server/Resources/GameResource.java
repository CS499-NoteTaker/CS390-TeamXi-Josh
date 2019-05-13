package Server.Resources;


import Core.GameLogic.Game;
import Core.UserData.Controller;
import Core.UserData.User;
import com.google.gson.Gson;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.io.InputStream;
import java.util.ArrayList;

@Singleton
@Path("game")
public class GameResource {

    // Fields
    // Now referring to Controller.games static variable



    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/GameResource.html");}

    //Get List of all games
    @GET
    public String getAllGames() {
        // Gets the currentUserName
        String currentUserName = WelcomeResource.currentUser.getUserName();
        // Gets All games regarding the Current User
        ArrayList<Game> userGames = Controller.gameList.getAllUserGames( currentUserName );
        // Converts all userGames into a list of SimpleGames
        ArrayList<SimpleGame> userSimpleGames = getGamesToSimpleGames( userGames );

        // Converts userSimple games to Json string.
        Gson gson = new Gson();
        return gson.toJson( userSimpleGames );

    }


    //Todo this does so by retrieving string, has not tried accepting json object
    /**
     * This will help to create game with current user and opponent
     * @param user2Name - user name of player 2 (opponent)
     * @return - returns 200 if successful
     */
    @POST
    public int createGame(String user2Name) {
        user2Name = user2Name.trim();

        // Checks if user has any input
        if( user2Name.length() == 0 ) {
            System.out.println("No string has been entered.");
            return 500;
        }

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
        } else {

            // Creates new game with two users
            Game newGame = new Game(user1, user2);
            Controller.gameList.addGameToList(newGame);

            System.out.println(newGame.getUser1());
            System.out.println(newGame.getUser2());
            return 200;
        }
    }


    /**
     * This gets a list of games converts to a list of SimpleGames and returns it.
     * @param games - list of Game objects
     * @return - a Simple Game object.
     */
    private ArrayList<SimpleGame> getGamesToSimpleGames( ArrayList<Game> games ) {
        ArrayList<SimpleGame> simpleGames = new ArrayList<>();
        int id;
        User user1, user2;
        Game tempGame;
        SimpleGame tempSimpleGame;

        for (int i = 0; i < games.size(); i++) {
            tempGame = games.get(i);
            id = tempGame.getID();
            user1 = tempGame.getUser1();
            user2 = tempGame.getUser2();

            tempSimpleGame = new SimpleGame(id, user1.getUserName(), user2.getUserName());

            simpleGames.add( tempSimpleGame );
        }

        return simpleGames;
    }

/*
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

*/

}

class SimpleGame {
    int id;
    String user1Name, user2Name;

    public SimpleGame(int id, String user1Name, String user2Name ) {
        this.id = id;
        this.user1Name = user1Name;
        this.user2Name = user2Name;
    }

}