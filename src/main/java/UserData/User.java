package UserData;

import GameLogic.Game;

import java.util.ArrayList;

public class User implements java.io.Serializable {


    String userName;
    int win, loss, userID;

    static ArrayList<Game> CurrentGames = new ArrayList<>();
    //ArrayList<Game> PreviousGames = new ArrayList<>();

    /*
    * Stories associated with the User class:
    * 1. As a player, I want to be able to create a user so that I can play games.
      2. As a player, I want to be able to create a new game (or several) by specifying the users involved so that I
        can begin playing by joining the game.
    */

    /**
     * Constructor for a User Object
     * @param user the username of the user
     */
    public User(String user){
        this.userName = user;
        win = 0;
        loss = 0;
        //userID = ID;
    }

    /**
     * Adds the given game to the User's current game list
     * @param NewGame Game to be added
     */
    public void addGame(Game NewGame){
        this.CurrentGames.add(NewGame);
    }

    /**
     * Returns the game at a given index
     * @param i index
     * @return The game at index i
     */
    public Game getGameAtindex(int i){
        return this.CurrentGames.get(i);
    }

    /**
     * Adds a win to the User's win count
     */
    public void addWin(){
        this.win++;
    }

    /**
     * Adds a loss to the User's loss count
     */
    public void addLoss(){
        this.loss++;
    }

    /**
     * Returns the User's win count
     * @return win
     */
    public int getWin(){
        return this.win;
    }

    /**
     * Returns the User's loss count
     * @return loss
     */
    public int getLoss(){
        return this.loss;
    }

    /**
     * Return the computed sum of the User's wins over their losses
     * @return win/loss
     */
    public double getWinLossRatio(){ return this.win / this.loss; }

    /**
     * Returns the User's Username with the UserName: attached
     * @return String
     */
    public String getUserName(){
        return "Username:" + this.userName + "";
    }

    /**
     * Returns the User's username
     * @return username
     */
    public String usernameToString() {return this.userName;}

    /**
     * Indicates if the current userName matches the given userName
     * @param otherUserName Name to compare the current userName to
     * @return boolean
     */
    public boolean UsernameEquals(String otherUserName){
        if(this.userName.equals(otherUserName)){
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the User's current Game List
     * @return String
     */
    public String getCurrentGames(){
        return this.CurrentGames.toString();
    }





}
