package GameLogic;

import UserData.User;
import UserData.UserList;

import java.io.*;
import java.util.Scanner;

public class GamePreparation {

    //The two Users needed for each game
    User UserOne,UserTwo;
    //Scanner for keyboard input
    Scanner keyboard = new Scanner(System.in);
    //Character Used for determining what the User inputs
    char userCreation;
    //The list of all Users
    UserList uList = new UserList();

    /**
     * Method that will be run before each game is created.
     */
    public GamePreparation(){

    }

    /**
     * Returns the first of two users attached to a game.
     * @return The User assigned to UserOne
     */
    public User getUserOne(){
        return UserOne;
    }

    /**
     * Returns the second of two users attached to a game.
     * @return The User assigned to UserOne
     */
    public User getUserTwo(){
        return UserTwo;
    }

    /**
     * Assigns the first of two Users of a game.
     * @param USERONE
     */
    public void setUserOne(User USERONE){
        UserOne = USERONE;
    }

    /**
     * Assigns the second of two Users of a game.
     * @param USERTWO
     */
    public void setUserTwo(User USERTWO){
        UserTwo = USERTWO;
    }

    /**
     * Finds a User if it is in the current User list or creates a new user and add
     * it to the current user list.
     * @return The new of old User
     */
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

    /**
     * Method that sets up new games or allows User to select an old game (replay)
     */
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
