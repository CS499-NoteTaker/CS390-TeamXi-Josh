package Server.Resources;


import GameLogic.Game;
import UserData.Controller;
import UserData.GameList;
import UserData.User;
import com.google.gson.Gson;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import UserData.Controller;

@Singleton
@Path("game")
public class GameResource {

    // Fields
    // Now referring to Controller.games static variable


    public GameResource() {
        Controller.gameList.addGameToList( new Game( new User("Josh"), new User("Daniel")) );
    }



    //Todo: Uncomment next two lines
    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/GameResource.html");}

    //Get List of all games
    @GET
    public String getAllGames() {
        Gson gson = new Gson();
        return gson.toJson( Controller.gameList.getGameAtIndex(0) );
    }

    /**
     * This will get the board information in json
     * @param GameID -  gameIndex
     * @return - json representation of game[id]
     */
    @Path("{id}")
    public String getGameInfo(@PathParam("id") String GameID){

        // Checks for 404 error
        int id = -1;
        try {
            id = Integer.parseInt(GameID);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }

        // Validate range
        //todo: change to gameList.getSize()
        if( id < 0 || id >= Controller.gameList.getSize() ) {
            throw new WebApplicationException(404);
        }


        //Gets the game at index 'id'
        Game gameId = Controller.gameList.getGameAtIndex(id);

        Gson gson = new Gson();

        //Json
        return gson.toJson( gson );
    }


    /**
     * This will help to create game with user1 and user 2
     * @param user1Name - user name from player 1
     * @param user2Name - user name from player 2
     * @return
     */
    @POST
    public int createGame(String twoUsers) {
        Scanner scan = new Scanner(twoUsers);

        // Checks to see if there have been an input of two users
        if( !hasTwoUsers( twoUsers ))
            throw new WebApplicationException( 406 );

        // Separates the input
        String user1Name = scan.next();
        String user2Name = scan.next();

        // Creates two users
        User user1 = Controller.userList.getUserByUsername( user1Name );
        User user2 = Controller.userList.getUserByUsername( user2Name );

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
