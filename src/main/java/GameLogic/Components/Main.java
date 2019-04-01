package GameLogic.Components;
import UserData.User;
import UserData.UserList;

import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    UserList uList = new UserList();


    public static void main(String[] args){
        boolean menu = true;
        int userMenuChoice;


        System.out.println("Welcome to Connect Six!");
        while(menu){
            System.out.println("What would you like to do? (1-3)");
            System.out.println("1) Play a game!");
            System.out.println("2) View the leaderboard!");
            System.out.println("3) View your completed game history!\n");
            userMenuChoice = keyboard.nextInt();
            keyboard.nextLine();

            if(userMenuChoice == 1){
                //create a new game (or choose from a list)?
                System.out.println("Player One: ");
                GamePreparation H = new GamePreparation();
                //H.PrepareGame();
                User one = H.findExistingUserOrCreateNewUser();
                while(one == null) {
                    System.out.println("Could not find your Username, please try again.");
                    one = H.findExistingUserOrCreateNewUser();
                }
                while(H != null){
                    H.NewGameOrWatchOldGame();
                }
            } else if(userMenuChoice == 2){
                System.out.println("Leaderboard!\n");
            }
            else if(userMenuChoice == 3){
                System.out.println("Game history!\n");
            }
        }
    }



}
