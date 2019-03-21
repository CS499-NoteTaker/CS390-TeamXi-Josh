package GameLogic.Components;
import UserData.*;
import java.util.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game {
    private boolean play = true;
    String createUser, userName;
    char userCreation;
    Scanner keyboard = new Scanner(System.in);
    UserList uList = new UserList();
    int x, y;

    public static void main(String args[]){
        Board gameBoard = new Board();
        Game g = new Game();
        g.play();
    }

    public void play(){
        Board gameBoard = new Board();
        System.out.println("Welcome to Connect Six!");

        //create a new game (or choose from a list)?
        System.out.println("Player One: ");
        User one = chooseUser();
        System.out.println("Player Two: ");
        User two = chooseUser();

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

        }
    }

    public User chooseUser(){
        System.out.println("Have you played before? Y/N");
        createUser = keyboard.nextLine();
        userCreation = createUser.toLowerCase().charAt(0);

        if(userCreation == 'y'){
            System.out.println("Please choose a user: ");
            System.out.println(uList.printUsers().toString());
        }else{
            //create a user
            System.out.println("Please enter a username: ");
            userName = keyboard.nextLine();
            User u = new User(userName);
            uList.addUser(u);
            return u;
        }
        return null;
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
