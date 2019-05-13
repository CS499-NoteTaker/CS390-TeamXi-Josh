package Server.Resources;

import Core.GameLogic.*;
import Core.UserData.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import java.io.InputStream;
import java.util.ArrayList;

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
    @GET
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
    public int placePointOnBoard(@PathParam("id") String gameId, String coordinateData ) {
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
        // so that a piece can be lied down accordingly
        if( currentUser.usernameEquals( player1.getUserName() ) ) {
            piece = Piece.B;
        } else if( currentUser.usernameEquals( player2.getUserName()) ) {
            piece = Piece.W;
        } else {
            piece = Piece.O;
            System.out.println(" Not current user is not player1 or player2");
        }

        currentGame.gameBoard.setPointAtLocation(coordinate.x, coordinate.y, piece);


        // Checks if who wins.
        if( currentGame.gameBoard.checkWinCondition() ) {
            if( piece == piece.B ) {
                // Player 1 wins
                currentGame.endGame( player1 ) ;
            }
            else if( piece == piece.W ) {
                // Player 2 wins
                currentGame.endGame(player2);
            } else {
                System.out.println("Error Winner, but wrong user");
            }
        }


        return 200;
    }





    /**
     * Converts an ArrayList of points to an ArrayList of SimplePoint objects
     * @param points - Arraylist of Point Objects
     * @return - an ArrayList of SimpleObjects
     */
    private ArrayList<SimplePoint> getPointsToSimplePoints(ArrayList<Point> points ) {
        ArrayList<SimplePoint> simplePoints = new ArrayList<>();
        int tempX, tempY;
        Piece tempPiece;
        Point tempPoint;
        SimplePoint tempSimplePoint;

        for (int i = 0; i < points.size(); i++ ) {
            tempPoint = points.get(i);
            tempX = tempPoint.getX();
            tempY = tempPoint.getY();
            tempPiece = tempPoint.getPiece();

            tempSimplePoint = new SimplePoint(tempX, tempY, tempPiece);

            simplePoints.add(tempSimplePoint);
        }

        return simplePoints;
    }

    /**
     * This returns all the occupied points from a game
     * @param game - game object to receive points from
     * @return - list of occupied points
     */
    private ArrayList<Point> getAllOccupiedPoints( Game game ) {
        ArrayList<Point> occupiedPoints = new ArrayList<>();
        Point tempPoint;

        for (int i = 0; i < 19; i++ ) {
            for (int j = 0; j < 19; j++ ) {
                tempPoint = game.gameBoard.getPointAtLocation(i, j);

                if ( tempPoint.isOccupied() )
                    occupiedPoints.add( tempPoint );
            }
        }

        return occupiedPoints;
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

    class SimplePoint {
        int x, y;
        Piece piece;

        public SimplePoint( int x, int y, Piece piece) {
            this.x = x;
            this.y = y;
            this.piece = piece;
        }
    }


}
