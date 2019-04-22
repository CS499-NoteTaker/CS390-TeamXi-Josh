package Server.Resources;

import com.google.gson.Gson;
import UserData.*;
import com.google.gson.JsonObject;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.*;

//TODO: leaderboard does not print out the string, users should be added to this list elsewhere

@Singleton
@Path("leaderboard")
public class LeaderboardResource {
    @GET
    public InputStream getClient() {return this.getClass().getResourceAsStream("/leaderboard.html");}

    @GET
    @Path("{file}")
    @Produces("application/javascript")
    public InputStream getClientJavascript(@PathParam("file") String fileName){
        InputStream stream = this.getClass().getResourceAsStream("/" + fileName);
        if(stream == null){
            throw new WebApplicationException(404);
        }
        return stream;
    }

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
        Gson g = new Gson();
        //return g.toJson(users);
        return leaderboard.toString();
        //return g.toJson(leaderboard.getLeaderboard());
    }

}
