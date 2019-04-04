package GameLogic;

import UserData.User;
import UserData.UserList;

import java.io.*;
import java.util.Scanner;

public class GamePreparation {
    User UserOne,UserTwo;
    Scanner keyboard = new Scanner(System.in);
    char userCreation;
    UserList uList = new UserList();


    public GamePreparation(){

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
            System.out.println("Have you played before? Y/N");
            String createUser = keyboard.nextLine();
            userCreation = createUser.toLowerCase().charAt(0);

            if(userCreation == 'y' || userCreation == 'Y'){
                //Array of Users
                System.out.println(uList.printUsers().toString());

                System.out.println("Please enter your Username:");
                String ReturnUser = keyboard.nextLine();
                setUserOne(uList.findUser(ReturnUser));
                return uList.findUser(ReturnUser);
            }else{
                //create a user
                System.out.println("Please enter a new Username: ");
                String NewUserName = keyboard.nextLine();
                User u = new User(NewUserName);
                if(uList.contains(NewUserName)){
                    return null;
                }
                uList.addUser(u);
                setUserOne(u);
                return u;
            }
    }

    public void NewGameOrWatchOldGame(){
        System.out.println("Would you like to play a new game or play a current game? N(New)/P(in-Progress)");
        char flag = keyboard.nextLine().charAt(0);
        if (flag == 'N' || flag == 'n'){
                System.out.println("Player Two: ");
                User two = findExistingUserOrCreateNewUser();
                while(two == null){
                    System.out.println("Could not find your Username, please try again.");
                    two = findExistingUserOrCreateNewUser();
                }
                setUserTwo(two);
                Game g = new Game(UserOne, UserTwo);
                uList.findUser(UserOne.usernameToString()).addGame(g);
                uList.findUser(UserTwo.usernameToString()).addGame(g);
                g.assignPlayers(UserOne, UserTwo);
                g.play();
            }
        else if(flag == 'P' || flag == 'p'){
                System.out.println(UserOne.getCurrentGames());
                System.out.println("Select the index of one of your current games(starting with 1): ");
                int gameIndex = keyboard.nextInt();
                UserOne.getGameAtindex(gameIndex).play();
            }
    }



}
