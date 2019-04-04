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
     * User object
     * @param user the username of the user
     */
    public User(String user){
        this.userName = user;
        win = 0;
        loss = 0;
        //userID = ID;
    }
    public void addGame(Game NewGame){
        this.CurrentGames.add(NewGame);
    }

    public Game getGameAtindex(int i){
        return this.CurrentGames.get(i);
    }

    public void addWin(){
        this.win++;
    }

    public void addLoss(){
        this.loss++;
    }

    public int getWin(){
        return this.win;
    }

    public int getLoss(){
        return this.loss;
    }

    public double getWinLossRatio(){ return this.win / this.loss; }

    //Spenser's persistence method
    public String toString(){
        return "Username:" + this.userName + "";
    }
    public String usernameToString() {return this.userName;}

    public boolean UsernameEquals(String otherUserName){
        if(this.userName.equals(otherUserName)){
            return true;
        }
        else
            return false;
    }

    public String getCurrentGames(){
        return this.CurrentGames.toString();
    }





}
