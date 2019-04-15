package Server.Resources;

import com.google.gson.Gson;
import UserData.*;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

//TODO: leaderboard does not print out the string, users should be added to this list elsewhere

@Singleton
@Path("leaderboard")
public class LeaderboardResource {
    public UserList users = new UserList();
    private Leaderboard leaderboard;

    public LeaderboardResource(){
        //users = uList.getUsers();
        users.addUser(new User("Kaitlyn"));
        users.addUser(new User("Spenser"));
        users.addUser(new User("Sola"));
        users.addUser(new User("Holden"));
        users.addUser(new User("Josh"));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLeaderboard(){
        leaderboard = new Leaderboard(users);
        return "[Kaitlyn, Spenser, Sola, Holden, Josh]" + leaderboard.leaderString().toString();
    }

}
