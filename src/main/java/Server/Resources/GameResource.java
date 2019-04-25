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
    //@GET
    //public InputStream getClient() {return this.getClass().getResourceAsStream("/GameResource.html");}

    //Get List of all games
    @GET
    public String getAllGames() {
        Gson gson = new Gson();
        return gson.toJson( Controller.gameList.getGameAtIndex(0) );
    }

    @Path("{id}")
    public String printGameGivenID(@PathParam("id") String GameID){

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


}
