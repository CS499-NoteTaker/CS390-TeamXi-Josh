package GameLogic;
import UserData.*;
import java.util.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game{
    //The two Users Needed for each game
    static User User1, User2;
    //Used to know if the game is still in progress
    private boolean play = true;
    //Ints used for placing a piece at a specific location
    int x, y;
    //Board used for storing every point
    private Board gameBoard = new Board();  //JOsh changed from public to private

    /**
     * Constructor for creating a game given the two Users that will
     * participate in the game.
     * @param PlayerOne The First User
     * @param PlayerTwo The Second User
     */
    public Game(User PlayerOne, User PlayerTwo) {
        this.User1 = PlayerOne;
        this.User2 = PlayerTwo;
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
    private void endGame(User u) {
        System.out.println("Congratulations " + u.usernameToString() + ", You won the game!\n");
    }
}
