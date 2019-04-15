package Server.Resources;

import GameLogic.GamePreparation;
import UserData.Leaderboard;
import UserData.User;
import UserData.UserList;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("menu")
public class MenuResource {

    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String getStartMenu(){
        StringBuilder output = new StringBuilder();
        output.append("Welcome to Connect Six!");
        output.append("\n");
        output.append("What would you like to do? (1-3)\n");
        output.append("1) Play a game!");
        output.append("2) View the leaderboard!\n");
        output.append("3) View your completed game history!\n");
        Gson gson = new Gson();
        return gson.toJson(output.toString());
    }


    @GET
    @Path("id")
    public void secondaryMenu(@PathParam("id") String inputNumber){
        int id = -1;
        try {
            id = Integer.parseInt(inputNumber);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }

        if(id != 1 || id != 2 || id != 3){
            throw new WebApplicationException(404);
        }

        if(id == 1){
            StringBuilder text = new StringBuilder();
            //create a new game (or choose from a list)?
            System.out.println("Player One: ");
            GamePreparation H = new GamePreparation();
            User one = H.findExistingUserOrCreateNewUser();
            while(one == null) {
                System.out.println("Could not find your Username, please try again.");
                one = H.findExistingUserOrCreateNewUser();
            }
            H.NewGameOrWatchOldGame();

        } else if(id == 2){
            Leaderboard newleaderboard = new Leaderboard(UserList.getAllUsers());
            System.out.print("LeaderBoard!\n");
            System.out.println(newleaderboard.toString());
        } else if(id == 3) {
            System.out.println("Game history!\n");
        }
    }

}
