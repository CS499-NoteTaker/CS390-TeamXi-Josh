package Server.Resources;

import Core.GameLogic.Game;
import Core.UserData.Controller;
import com.google.gson.Gson;

import javax.ws.rs.*;
import java.io.InputStream;

@Path("current")
public class CurrentGameResource {

    public static int currentGameId;

    public CurrentGameResource() {

    }



    @GET
    public InputStream getPlay() { return this.getClass().getResourceAsStream("/currentGame.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getPlayJavascript(@PathParam("file") String fileName) {
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if (stream == null){
            throw new WebApplicationException(404);
        }
        return stream;

    }





    /**
     * This will get the board information in json
     * @param GameId -  gameIndex
     * @return - json representation of game[id]
     */
    @Path("{id}")
    public String getGameInfo(@PathParam("id") String GameId){

        // Checks for 404 error
        int id = -1;
        try {
            id = Integer.parseInt(GameId);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }

        // Validate range
        //todo: change to gameList.getSize()
        if( id < 0 || id >= Controller.gameList.getSize() ) {
            throw new WebApplicationException(404);
        }

        currentGameId = id;

        //Gets the game at index 'id'
        Game gameAtId = Controller.gameList.getGameAtIndex(id);

        Gson gson = new Gson();

        //Json
        return gson.toJson( gameAtId );
    }




    @PUT
    @Path("{id}/placePoint")
    public String placePointOnBoard(@PathParam("id") String GameId ) {
        // Convert to an integer
        int id = -1;
        try {
            id = Integer.parseInt( GameId );
        } catch( NumberFormatException e ) {
            throw new WebApplicationException(404);
        }

        // Validate range
        if( id < 0 || id >= Controller.gameList.getSize() ) {
            throw new WebApplicationException(404);
        }


        return "";
    }





}
