package UserData;

public class User {
    /*
    * Stories associated with the User class:
    * 1. As a player, I want to be able to create a user so that I can play games.
      2. As a player, I want to be able to create a new game (or several) by specifying the users involved so that I
        can begin playing by joining the game.
    */
    String userName;
    int win, loss, userID;
    /**
     * User object
     * @param user the username of the user
     */
    public User(String user){
        this.userName = user;
        win = 0;
        loss = 0;
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

}
