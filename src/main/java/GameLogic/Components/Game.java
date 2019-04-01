package GameLogic.Components;
import UserData.*;
import java.util.*;
import java.io.*;

//TODO: Implement the ability to choose a user from a list,
//TODO: Implement the win condition, set play to false when the game is complete
//TODO: Add a win and loss to the correct users

public class Game implements java.io.Serializable {
    private boolean play = true;
    String createUser, userName;
    char userCreation;
    Scanner keyboard = new Scanner(System.in);
    UserList uList = new UserList();
    int x, y;


    public void play(){
        Board gameBoard = new Board();
        System.out.println("Welcome to Connect Six!");

        //create a new game (or choose from a list)?
        System.out.println("Player One: ");
        User one = chooseUser();
        while(one == null){
            System.out.println("Could not find your UserName, please try again.");
            one = chooseUser();
        }
        System.out.println("Player Two: ");
        User two = chooseUser();
        while(two == null){
            System.out.println("Could not find your UserName, please try again.");
            two = chooseUser();
        }

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
        try{
            System.out.println("Have you played before? Y/N");
            createUser = keyboard.nextLine();
            userCreation = createUser.toLowerCase().charAt(0);
            String filename = "file.ser";

            if(userCreation == 'y' || userCreation == 'Y'){
                //TODO: Spenser, here is where we will need to have the user to enter their username rather than choose a user
                //Deserialization
                //Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                //Method for deserialization
                uList = (UserList)in.readObject();
                in.close();
                file.close();

                System.out.println(uList.printUsers().toString());

                System.out.println("Please enter your userName:");
                String ReturnUser = keyboard.nextLine();
                //System.out.println("@Game@ chooseUser: ReturnUser =" + ReturnUser);
                //System.out.println("@Game@ chooseuser: uList data =" + uList.toString());
                return uList.findUser(ReturnUser);
            }else{
                //create a user
                System.out.println("Please enter a UserName: ");
                userName = keyboard.nextLine();
                //System.out.println("please enter a UserID");
                //int userID = keyboard.nextInt();
                User u = new User(userName);
                if(uList.Contains(userName)){
                    return null;
                }
                uList.addUser(u);

                //Serialization
                //Saving object to file
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
                //Method for Serialization
                out.writeObject(uList);
                out.close();
                file.close();

                return u;
            }

        }
        catch(IOException ex)
        {
            System.out.print("IOException is caught");
        }
        catch(ClassNotFoundException ex){
            System.out.print("ClassNotFoundException is caught");
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
