package UserData;
import UserData.*;
import java.util.*;

public class UserList{
    //An array that stores all the unique users
     private ArrayList<User> users = new ArrayList<>();

    public UserList(){
        User Kaitlyn = new User("Kaitlyn");
        Kaitlyn.addWin();
        Kaitlyn.addWin();
        Kaitlyn.addWin();



        User Spenser = new User("Spenser");
        Spenser.addWin();
        Spenser.addWin();
        Spenser.addWin();


        User Sola = new User("Sola");
        Sola.addWin();
        Sola.addWin();

        User Holden = new User("Holden");
        Holden.addWin();
        Holden.addWin();

        User Josh = new User("Josh");
        Josh.addWin();
        Josh.addWin();

        users.add(Kaitlyn);
        users.add(Spenser);
        users.add(Sola);
        users.add(Holden);
        users.add(Josh);
    }

    /**
     * Returns the arrayList of all Users
     * @return ArrayList
     */
    public ArrayList<User> getAllUsers(){
        return users;
    }

    /**
     * Adds the new user to the list of all users
     * @param user the username that the user chose
     */
    public void addUser(User user){
        users.add(user);
    }

    /**
     * returns All the usernames in string form
     * @return the usernames
     */
    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            build.append(users.get(i).usernameToString() + " ");
        }
        String build1 = build.toString();
        return build1;
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
     * Returns the size of the users size
     * @return users size
     */
    public int getSize(){
        return users.size();
    }

    public User getUserByIndex(int i){
        return users.get(i);
    }

    public User getUserByUsername(String username){
        return findUser(username);
    }


}
