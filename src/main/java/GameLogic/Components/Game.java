package GameLogic.Components;
import UserData.*;
import java.util.*;
import java.io.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game implements java.io.Serializable {
    private boolean play = true;
    static User User1, User2;
    Scanner keyboard = new Scanner(System.in);
    int x, y;

    public Game(User PlayerOne, User PlayerTwo){
        this.User1 = PlayerOne;
        this.User2 = PlayerTwo;
    }

    public void assignPlayers(User FirstPlayer, User Secondplayer){
        this.User1 = FirstPlayer;
        this.User2 = Secondplayer;
    }

    public void play(){

        Board gameBoard = new Board();
        System.out.println("Welcome to Connect Six!");
        System.out.println("\n");
        while(play){
            gameBoard.printBoard();
            System.out.println("\nPlayer one, please pick an x coordinate: ");
            x = keyboard.nextInt();
            System.out.println("Player one, please pick a y coordinate: ");
            y = keyboard.nextInt();
            Point chosenPiece = gameBoard.getPointAtLocation(y, x);
            while(chosenPiece.isOccupied()){
                System.out.println("Invalid coordinates!");System.out.println("\nPlayer one, please pick an x coordinate: ");
                x = keyboard.nextInt();
                System.out.println("Player one, please pick a y coordinate: ");
                y = keyboard.nextInt();
                chosenPiece = gameBoard.getPointAtLocation(y, x);
            }
            chosenPiece.setPiece(Piece.B);
            gameBoard.setPointAtLocation(y, x, chosenPiece.getPiece());
            System.out.println("\n");
            gameBoard.printBoard();
            if(gameBoard.checkWinCondition() == true){
                endGame(User1);
                return;
            }
            System.out.println("\nPlayer two, please pick an x coordinate: ");
            x = keyboard.nextInt();
            System.out.println("Player two, please pick a y coordinate: ");
            y = keyboard.nextInt();
            chosenPiece = gameBoard.getPointAtLocation(y, x);

            while(chosenPiece.isOccupied()){
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
            if(gameBoard.checkWinCondition() == true){
                endGame(User2);
                return;
            }

        }
    }

    public void endGame(User u){
        System.out.println("Congratulations " + u.userNametoString() + ", You won the game!");
    }

}

  /*
        Point chosenPiece = gameBoard.getPointAtLocation(2, 2);
        System.out.println(chosenPiece.getPiece());
        chosenPiece.setPiece(Piece.B);
        System.out.println(chosenPiece.getPiece());
        gameBoard.setPointAtLocation(2, 2, chosenPiece.getPiece());
        chosenPiece = gameBoard.getPointAtLocation(5, 5);
        chosenPiece.setPiece(Piece.W);
        gameBoard.setPointAtLocation(5, 5, chosenPiece.getPiece());
        gameBoard.printBoard();*/
