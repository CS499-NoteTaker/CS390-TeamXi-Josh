package Server.Resources;

import GameLogic.Game;
import GameLogic.Piece;
import GameLogic.Point;
import UserData.Controller;
import UserData.GameList;
import UserData.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import java.io.InputStream;

import static GameLogic.Piece.B;

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




    @POST
    @Path("{id}/placePoint")
    public String placePointOnBoard(@PathParam("id") String gameId, String coordinateData ) {
        // Convert to an integer
        int id = -1;
        try {
            id = Integer.parseInt( gameId );
        } catch( NumberFormatException e ) {
            throw new WebApplicationException(404);
        }

        // Validate range
        if( id < 0 || id >= Controller.gameList.getSize() ) {
            throw new WebApplicationException(404);
        }

        // Parse the data from the client
        JsonObject jsonObj = new JsonObject();
        int xCord = Integer.parseInt( String.valueOf(jsonObj.get("x")) );


        //Todo: make sure to track the moves into the move list as well
        Piece piece;
        Coordinate coordinate;
        User player1, player2, currentUser;
        Game currentGame;

        // Converts the x and y coordinates from json to Coordinate object
        Gson gson = new Gson();
        coordinate = gson.fromJson(coordinateData, Coordinate.class);

        // Grabs necessary game data
        currentUser = WelcomeResource.currentUser;
        currentGame = Controller.gameList.getGameAtIndex( id );
        player1 = currentGame.getUser1();
        player2 = currentGame.getUser2();


        // Checks to see which player the current player is within the game
        // so that a piece can be layed down accordingly
        if( currentUser.usernameEquals( player1.getUserName() ) ) {
            piece = Piece.B;
        } else if( currentUser.usernameEquals( player2.getUserName()) ) {
            piece = Piece.W;
        } else {
            piece = Piece.O;
            System.out.println(" Not current user is not player1 or player2");
        }

        currentGame.gameBoard.setPointAtLocation(coordinate.x, coordinate.y, piece);

        return "200";
    }



    class Coordinate {
        int x;
        int y;

        public Coordinate( int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }

        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
    }


}
