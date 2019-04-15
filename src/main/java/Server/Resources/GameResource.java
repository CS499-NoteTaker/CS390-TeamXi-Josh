package Server.Resources;


import GameLogic.Game;
import GameLogic.GameList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

@Path("game")
public class GameResource {

    @GET
    @PathParam("id")
    public void printGameGivenID(@PathParam("id") String GameID){
        int id = -1;
        try {
            id = Integer.parseInt(GameID);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }
        GameList temp = new GameList();
        Game g = temp.getGameAtIndex(id);
        g.gameBoard.toString();
        
    }

}
