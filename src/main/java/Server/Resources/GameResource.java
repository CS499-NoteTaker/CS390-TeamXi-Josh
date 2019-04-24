package Server.Resources;


import GameLogic.Game;
import UserData.GameList;
import javax.ws.rs.*;

@Path("game")
public class GameResource {

    @GET
    @Path("{id}")
    public String printGameGivenID(@PathParam("id") String GameID){
        int id = -1;
        try {
            id = Integer.parseInt(GameID);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }
        GameList temp = new GameList();
        Game g = temp.getGameAtIndex(id);
        return(g.gameBoard.toString());
        
    }


}
