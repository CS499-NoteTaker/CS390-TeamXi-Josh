package GameLogic;

import UserData.User;
import UserData.UserList;

public class GamePreparation {

    //The two Users needed for each game
    User UserOne,UserTwo;
    //The list of all Users
    UserList uList = new UserList();

    /**
     * Method that will be run before each game is created.
     */
    public GamePreparation(){

    }

    /**
     * Returns the first of two users attached to a game.
     * @return The User assigned to UserOne
     */
    public User getUserOne(){
        return UserOne;
    }

    /**
     * Returns the second of two users attached to a game.
     * @return The User assigned to UserOne
     */
    public User getUserTwo(){
        return UserTwo;
    }

    /**
     * Assigns the first of two Users of a game.
     * @param USERONE
     */
    public void setUserOne(User USERONE){
        UserOne = USERONE;
    }

    /**
     * Assigns the second of two Users of a game.
     * @param USERTWO
     */
    public void setUserTwo(User USERTWO){
        UserTwo = USERTWO;
    }


}
