package Core.GameLogic;
import Core.UserData.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game{
    private User User1, User2;      //The two Users Needed for each game
    public boolean play;//Used to know if the game is still in progress
    public static int globalId = 0;
    public int id;
    //Board used for storing every point
    public Board gameBoard;  //Josh changed back to public


    /**
     * Constructor for creating a game given the two Users that will
     * participate in the game.
     * @param PlayerOne The First User
     * @param PlayerTwo The Second User
     */
    public Game(User PlayerOne, User PlayerTwo) {
        this.User1 = PlayerOne;
        this.User2 = PlayerTwo;
        this.play = true;
        this.gameBoard = new Board();
        this.id = getID();
    }

    /**
     * Assigns two Users to a given game
     * @param firstPlayer The First User
     * @param secondPlayer The Second User
     */
    public void assignPlayers(User firstPlayer, User secondPlayer) {
        this.User1 = firstPlayer;
        this.User2 = secondPlayer;
    }

    /**
     * Ends the current game and prints the winning line
     * @param u The winner of the game
     */
    public void endGame(User u) {
        this.play = false;
        u.addWin();
        this.User2.addLoss();
        System.out.println("Congratulations " + u.getUserName() + ", You won the game!\n");
    }


    /**
     * Returns the first user
     * @return The first User
     */
    public User getUser1(){
        return User1;
    }

    /**
     * Returns the second user
     * @return The second user
     */
    public User getUser2(){
        return User2;
    }

    public int getID(){
        globalId += 1;
        return globalId;
    }


}
