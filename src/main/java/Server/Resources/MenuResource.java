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

        return("Welcome to Connect Six!\nWhat would you like to do? (1-3)\n" +
                "1) Play a game!\n2) View the leaderboard!\n3) View your completed game history!\n");
    }


    @GET
    @Path("{input}")
    public int secondaryMenu(@PathParam("input") String inputNumber) {
        int input = -1;
        try {
            input = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new WebApplicationException(404);
        }

        if (input<= 0 || input >=4) {
            throw new WebApplicationException(404);
        }

        if (input == 1) {
            //create a new game (or choose from a list)?
            //TODO: Need to fix this so the test does not rely on user input
            return 1;
            /*
            System.out.println("Player One: ");
            GamePreparation H = new GamePreparation();
            User one = H.findExistingUserOrCreateNewUser();
            while (one == null) {
                System.out.println("Could not find your Username, please try again.");
                one = H.findExistingUserOrCreateNewUser();
            }
            H.NewGameOrWatchOldGame();


            return 1;
            */


        } else if (input == 2) {
            UserList users = new UserList();
            users.addUser(new User("Kaitlyn"));
            users.addUser(new User("Spenser"));
            users.addUser(new User("Sola"));
            users.addUser(new User("Holden"));
            users.addUser(new User("Josh"));
            Leaderboard newleaderboard = new Leaderboard(users);
            System.out.print("LeaderBoard!\n");
            System.out.println(newleaderboard.toString());
            return 2;
        } else if (input == 3) {
            System.out.println("Game history!\n");
            return 3;
        }
        return -1;
    }


}
