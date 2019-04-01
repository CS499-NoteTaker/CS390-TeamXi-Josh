package GameLogic.Components;
import UserData.User;
import UserData.UserList;

import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    UserList uList = new UserList();



    public static void main(String[] args){

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
    }



}
