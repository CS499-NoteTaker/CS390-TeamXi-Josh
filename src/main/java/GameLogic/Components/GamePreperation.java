package GameLogic.Components;
import java.util.*;
import UserData.User;
import UserData.UserList;

import java.io.*;
import java.util.Scanner;

public class GamePreperation {
    User UserOne,UserTwo;
    Scanner keyboard = new Scanner(System.in);
    char userCreation;
    UserList uList = new UserList();


    public GamePreperation(){

    }

    public void PrepareGame(){

        findExistingUserOrCreateNewUser();
    }

    public User getUserOne(){
        return UserOne;
    }

    public User getUserTwo(){
        return UserTwo;
    }

    public void setUserOne(User USERONE){
        UserOne = USERONE;
    }
    public void setUserTwo(User USERTWO){
        UserTwo = USERTWO;
    }

    //Username = The second user in game
    public User findExistingUserOrCreateNewUser(){
        try{
            System.out.println("Have you played before? Y/N");
            String createUser = keyboard.nextLine();
            userCreation = createUser.toLowerCase().charAt(0);
            String filename = "file.ser";

            if(userCreation == 'y' || userCreation == 'Y'){
                //Deserialization
                //Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                //Method for deserialization
                uList = (UserList)in.readObject();
                in.close();
                file.close();

                System.out.println(uList.printUsers().toString());

                System.out.println("Please enter your UserName:");
                String ReturnUser = keyboard.nextLine();
                setUserOne(uList.findUser(ReturnUser));
                return uList.findUser(ReturnUser);
            }else{
                //create a user
                System.out.println("Please enter a new UserName: ");
                String NewUserName = keyboard.nextLine();
                User u = new User(NewUserName);
                if(uList.contains(NewUserName)){
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
                setUserOne(u);
                return u;
            }
        }
        catch(IOException ex){System.out.println("IOException is caught");}
        catch(ClassNotFoundException ex){System.out.println("ClassNotFoundException is caught");}

        return null;
    }

    public void NewGameOrWatchOldGame(){
        System.out.println("Would you like to play a new game or look at a previous game? N(New)/P(Previous)");
        char flag = keyboard.nextLine().charAt(0);
        if (flag == 'N' || flag == 'n'){
            try{
                System.out.println("Player Two: ");
                User two = findExistingUserOrCreateNewUser();
                while(two == null){
                    System.out.println("Could not find your UserName, please try again.");
                    two = findExistingUserOrCreateNewUser();
                }
                setUserTwo(two);
                String filename = "file.ser";
                //Deserialization
                //Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                //Method for deserialization
                uList = (UserList)in.readObject();
                in.close();
                file.close();
                Game g = new Game(UserOne, UserTwo);
                uList.findUser(UserOne.userNametoString()).addGame(g);
                uList.findUser(UserTwo.userNametoString()).addGame(g);
                g.assignPlayers(UserOne, UserTwo);

                System.out.println("GAMEPREP: U1Games: " + UserOne.getCurrentGames());


                //Serialization
                //Saving object to file
                FileOutputStream fileout = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileout);
                //Method for Serialization
                out.writeObject(uList);
                out.close();
                file.close();
                g.play();
            }
            catch(IOException ex){System.out.println("IOException is caught");}
            catch(ClassNotFoundException ex){System.out.println("ClassNotFoundException is caught");}

        }
        else if(flag == 'P' || flag == 'p'){
            try{
                String filename = "file.ser";
                //Deserialization
                //Reading the object from a file
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                //Method for deserialization
                uList = (UserList)in.readObject();
                in.close();
                file.close();

                System.out.println(UserOne.getCurrentGames());
                System.out.println("Select the index of one of your current games(starting with 1): ");
                int gameIndex = keyboard.nextInt();
                UserOne.getGameAtindex(gameIndex).play();
            }
            catch(IOException ex){System.out.println("IOException is caught");}
            catch(ClassNotFoundException ex){System.out.println("ClassNotFoundException is caught");}

        }
    }



}
