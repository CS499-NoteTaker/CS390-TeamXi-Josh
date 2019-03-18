package UserData;
import java.util.*;

public class UserList {
    ArrayList<User> users = new ArrayList<>();

    /**
     * Adds the new user to the list of all users
     * @param user the username that the user chose
     */
    private void addUser(User user){
        users.add(user);
    }

    /*

    Stubs for potential methods needed for later.

    public User[] getOnlineUsers(){
        return (User[])users.toArray();
    }

    private void updateUserStatus(){

    }*/

    /*
    public User[] getLeaderboard(){
        User[] leaderboard = Leaderboard.getLeaderboard();
        return leaderboard;
    }*/

}
