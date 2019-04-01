package GameLogic.Components;

import UserData.User;

import java.util.ArrayList;

public class Leaderboard {
    private ArrayList<User> leaderboard;

    public Leaderboard(ArrayList<User> users){
        leaderboard = sortUsersByWinLossRatioHighestToLowest(users);
    }

    public ArrayList<User> getLeaderboard(){
        return leaderboard;
    }

    private ArrayList<User> sortUsersByWinLossRatioHighestToLowest(ArrayList<User> users){
        ArrayList<User> usersSorted = new ArrayList<User>();
        for(int i = 0; i < users.size(); i++){
            usersSorted = putUserInRightPlace(users.get(i), usersSorted);
        }
        return usersSorted;
    }

    /**
     * Puts a single user in the right part of the "sorted" userList based on W/L ratio
     * @return The ArrayList, with the user added to it
     */
    private ArrayList<User> putUserInRightPlace(User user, ArrayList<User> usersSorted){
        //TODO: Perhaps add a check method to see if the user is already in the usersSorted ArrayList?
        boolean userHasBeenInserted = false;
        for(int i = 0; i < usersSorted.size(); i++) {
            if(!userHasBeenInserted && user.getWinLossRatio() >= usersSorted.get(i).getWinLossRatio()){
                usersSorted.add(i, user);
                userHasBeenInserted = true;
            }
        }
        return usersSorted;
    }

    public void printLeaderboard(){
        for(int i = 0; i < leaderboard.size(); i++){
            System.out.println(leaderboard.get(i).toString() + " W/L Ratio: " + leaderboard.get(i).getWinLossRatio());
        }
    }
}
