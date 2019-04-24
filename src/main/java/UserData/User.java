package UserData;

import GameLogic.Game;

import java.util.ArrayList;

public class User implements java.io.Serializable {
    //The Name that the users will give their account
    String userName;
    //Attributes to keep each users wins and losses
    int win, loss;

    ArrayList<Game> currentGames = new ArrayList<>();
    ArrayList<Game> previousGames = new ArrayList<>();
    /**
     * Constructor for a User Object
     * @param user the username of the user
     */
    public User(String user){
        this.userName = user;
        win = 0;
        loss = 0;
    }

    /**
     * Adds the given game to the User's current game list
     * @param NewGame Game to be added
     */
    public void addGame(Game NewGame){
        this.currentGames.add(NewGame);
    }

    /**
     * Returns the game at a given index
     * @param i index
     * @return The game at index i
     */
    public Game getGameAtindex(int i){
        return this.currentGames.get(i);
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
        return this.userName;
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
        return this.currentGames.toString();
    }





}
