package UserData;

public class User {
    /*
    * Stories associated with the User class:
    * 1. As a player, I want to be able to create a user so that I can play games.
      2. As a player, I want to be able to create a new game (or several) by specifying the users involved so that I
        can begin playing by joining the game.
    */
    String userName, password;

    /**
     * User object
     * @param user the username of the user
     */
    public User(String user){
        this.userName = user;
    }

}
