package GameLogic;
import UserData.*;
import java.util.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game implements java.io.Serializable {
    static User User1, User2;
    Scanner keyboard = new Scanner(System.in);
    private boolean play = true;
    int x, y;

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
     * @param FirstPlayer The First User
     * @param Secondplayer The Second User
     */
    public void assignPlayers(User FirstPlayer, User Secondplayer) {
        this.User1 = FirstPlayer;
        this.User2 = Secondplayer;
    }

    /**
     * Begins the game logic and continues up to the end
     */
    public void play() {
        Board gameBoard = new Board();
        System.out.println("\n");

        while (play) {
            gameBoard.printBoard();
            System.out.println("\nPlayer one, please pick an x coordinate: ");
            x = keyboard.nextInt();
            System.out.println("Player one, please pick a y coordinate: ");
            y = keyboard.nextInt();
            Point chosenPiece = gameBoard.getPointAtLocation(y, x);
            while (chosenPiece.isOccupied()) {
                System.out.println("Invalid coordinates!");
                System.out.println("\nPlayer one, please pick an x coordinate: ");
                x = keyboard.nextInt();
                System.out.println("Player one, please pick a y coordinate: ");
                y = keyboard.nextInt();
                chosenPiece = gameBoard.getPointAtLocation(y, x);
            }
            chosenPiece.setPiece(Piece.B);
            gameBoard.setPointAtLocation(y, x, chosenPiece.getPiece());
            System.out.println("\n");
            gameBoard.printBoard();
            if (gameBoard.checkWinCondition()) {
                endGame(User1);
                return;
            }
            System.out.println("\nPlayer two, please pick an x coordinate: ");
            x = keyboard.nextInt();
            System.out.println("Player two, please pick a y coordinate: ");
            y = keyboard.nextInt();
            chosenPiece = gameBoard.getPointAtLocation(y, x);

            while (chosenPiece.isOccupied()) {
                System.out.println("Invalid coordinates!");
                System.out.println("\nPlayer two, please pick an x coordinate: ");
                x = keyboard.nextInt();
                System.out.println("Player two, please pick a y coordinate: ");
                y = keyboard.nextInt();
                chosenPiece = gameBoard.getPointAtLocation(y, x);
            }

            chosenPiece.setPiece(Piece.W);
            gameBoard.setPointAtLocation(y, x, chosenPiece.getPiece());
            System.out.println("\n");

            if (gameBoard.checkWinCondition()) {
                endGame(User2);
                return;
            }
        }
    }

    /**
     * Ends the current game and prints the winning line
     * @param u The winner of the game
     */
    private void endGame(User u) {
        System.out.println("Congratulations " + u.usernameToString() + ", You won the game!\n");
    }
}
