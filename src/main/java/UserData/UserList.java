package UserData;
import java.io.Serializable;
import java.util.*;

public class UserList{
    //An array that stores all the unique users
    static ArrayList<User> users = new ArrayList<>();


    /**
     * Returns the arrayList of all Users
     * @return ArrayList
     */
    public static ArrayList<User> getAllUsers(){
        return users;
    }




    /**
     * Adds the new user to the list of all users
     * @param user the username that the user chose
     */
    public static void addUser(User user){
        users.add(user);
    }
    public ArrayList<User> printUsers(){
        return users;
    }

    /**
     * returns the first User in the users List
     * @return The first User
     */
    public String toString(){
        for(int i = 0; i < users.size(); i++){
            String user = users.get(i).userName;
            return user;
        }

        return null;
    }

    /**
     * Finds a User
     * @param TheUser
     * @return
     */
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

    /**
     * Checks if the users list has a User by the given username.
     * @param UserName - String username of the user it is looking for
     * @return - true if the userlist contains the user by the given username
     */
    public Boolean contains(String UserName){
        for(int i = 0; i < users.size(); i ++){
            if(UserName.compareTo(users.get(i).userName) == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the entire users list
     * @return A List of Users in the users list
     */
    public ArrayList<User> getUsers(){
        return users;
    }


    /**
     * Returns the size of the users size
     * @return users size
     */
    public int getSize(){
        return users.size();
    }

    public User getUser(int i){
        return users.get(i);
    }

    /*
    Stubs for potential methods needed for later.

    private void updateUserStatus(){

    }*/

}
