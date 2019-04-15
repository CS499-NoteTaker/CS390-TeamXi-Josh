package Server.Resources;

import GameLogic.GamePreparation;
import UserData.Leaderboard;
import UserData.User;
import UserData.UserList;
import com.google.gson.Gson;

import javax.ws.rs.*;

@Path("menu")
public class MenuResource {

    @GET
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
    @Path("input")
    public void secondaryMenu(@PathParam("input") String inputNumber){
        int input = -1;
        try {
            input = Integer.parseInt(inputNumber);
        }
        catch(NumberFormatException e){
            throw new WebApplicationException(404);
        }

        if(input != 1 || input != 2 || input != 3){
            throw new WebApplicationException(404);
        }

        if(input == 1){
            //create a new game (or choose from a list)?
            System.out.println("Player One: ");
            GamePreparation H = new GamePreparation();
            User one = H.findExistingUserOrCreateNewUser();
            while(one == null) {
                System.out.println("Could not find your Username, please try again.");
                one = H.findExistingUserOrCreateNewUser();
            }
            H.NewGameOrWatchOldGame();

        } else if(input == 2){
            UserList users = new UserList();
            users.addUser(new User("Kaitlyn"));
            users.addUser(new User("Spenser"));
            users.addUser(new User("Sola"));
            users.addUser(new User("Holden"));
            users.addUser(new User("Josh"));
            Leaderboard newleaderboard = new Leaderboard(users);
            System.out.print("LeaderBoard!\n");
            System.out.println(newleaderboard.toString());
        } else if(input == 3) {
            System.out.println("Game history!\n");
        }
    }

}
