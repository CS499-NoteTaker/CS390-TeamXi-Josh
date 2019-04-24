package Server.Resources;


import GameLogic.Game;
import UserData.GameList;
import UserData.User;
import com.google.gson.Gson;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("game")
public class GameResource {

    //Fields
    private GameList gameList = new GameList();


    public GameResource() {
        gameList.addGameToList( new Game( new User("Josh"), new User("Daniel")) );
        gameList.addGameToList( new Game( new User("aaaaaaa"), new User("bbbbbbb")) );
        gameList.addGameToList( new Game( new User("ooooooo"), new User("llllllll")) );
    }



    //Todo: Uncomment next two lines
    //@GET
    //public InputStream getClient() {return this.getClass().getResourceAsStream("GameResource/.html");}

    //Get List of all games
    @GET
    public String getAllGames() {
        Gson gson = new Gson();
        return gson.toJson( gameList );
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
        if( id < 0 || id >= gameList.getSize() ) {
            throw new WebApplicationException(404);
        }


        //Gets the game at index 'id'
        Game gameId = gameList.getGameAtIndex(id);

        Gson gson = new Gson();

        //Json
        return gson.toJson( gson );
    }


}
