package UserData;
import java.io.Serializable;
import java.util.*;

public class UserList implements Serializable {
    ArrayList<User> users = new ArrayList<>();

    /**
     * Adds the new user to the list of all users
     * @param user the username that the user chose
     */
    public void addUser(User user){
        users.add(user);
    }
    public ArrayList<User> printUsers(){
        return users;
    }

    public String toString(){
        for(int i = 0; i < users.size(); i++){
            String user = users.get(i).userName;
            return user;
        }
        return null;
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
