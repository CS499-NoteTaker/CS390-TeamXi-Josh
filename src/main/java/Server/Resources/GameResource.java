package Server.Resources;


import GameLogic.Game;
import GameLogic.GameList;
import javax.ws.rs.*;
import java.io.InputStream;

@Path("game")
public class GameResource {

    //Todo: Uncomment next two lines
    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("GameResource/.html");}

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
