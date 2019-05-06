package GameLogic;
import UserData.*;
import java.util.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game{
    //The two Users Needed for each game
    private User User1, User2;
    //Used to know if the game is still in progress
    private boolean play = true;
    //Ints used for placing a piece at a specific location
    private int x, y;
    //Board used for storing every point
    private Board gameBoard = new Board();  //Josh changed from public to private
    private int id = 0;

    /**
     * Constructor for creating a game given the two Users that will
     * participate in the game.
     * @param PlayerOne The First User
     * @param PlayerTwo The Second User
     */
    public Game(User PlayerOne, User PlayerTwo) {
        this.User1 = PlayerOne;
        this.User2 = PlayerTwo;
        this.id = assignId();
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
     * Creates a unique ID for each game created
     * @return Game ID
     */
    private int assignId(){
        return id++;
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

    /**
     * Returns the game's ID
     * @return game's ID
     */
    public int getID(){
        return id;
    }
}
