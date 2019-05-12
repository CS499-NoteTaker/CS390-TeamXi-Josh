package Server.Resources;

import com.google.gson.Gson;

import Core.UserData.*;


import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;


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


    private Leaderboard leaderboard;
    UserList users = Controller.userList;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLeaderboard(){
        leaderboard = new Leaderboard();
        Gson g = new Gson();
        return g.toJson(leaderboard.getLeaderboardObjectArray());
    }

    @POST
    @Path("{username}")
    public void addUserToLeaderboard(@PathParam("username") String username){
        leaderboard.addUserToLeaderboard(users.findUser(username));
    }


}
