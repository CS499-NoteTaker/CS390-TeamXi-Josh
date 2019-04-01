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

    public User findUser(String TheUser) {
        for(int i = 0; i < users.size(); i++) {
            if(TheUser.compareTo(users.get(i).userName) == 0) {
                User user = users.get(i);
                int TheUserInt = users.indexOf(user);
                return users.get(TheUserInt);
            }
        }
        return null;
    }

    public Boolean contains(String UserName){
        for(int i = 0; i < users.size(); i ++){
            if(UserName.compareTo(users.get(i).userName) == 0){
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUserList(){
        return users;
    }


    public int GetSize(){
        return users.size();
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

    //SPENCER'S PERSISTENCE TEST METHOD
    //    public User FindUser(String TheUser) {
//        for(int i = 0; i < users.size(); i++) {
//            if(TheUser.compareTo(users.get(i).userName) == 0) {
//                User user = users.get(i);
//                int TheUserInt = users.indexOf(user);
//                return users.get(TheUserInt);
//            }
//        }
//        return null;
//    }

}
