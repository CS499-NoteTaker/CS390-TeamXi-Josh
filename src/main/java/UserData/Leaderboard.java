package UserData;
import java.util.*;

public class Leaderboard {
    ArrayList<User> leaderboardList = new ArrayList<>();
     User[] leaderboard;
    //get all of the users from user list, get the win ratio from each user, add them to the array list, order
    //the array list by wins. print that.

    private void createLeaderboard(ArrayList<User> userList){
        for(int i = 0; i < userList.size(); i++){
            int win = userList.get(i).getWin();
            int loss = userList.get(i).getLoss();
            int mostWinsToLoss = 0;
            for(int j = 0; j < userList.size(); j++){
                if(win > loss){
                    //is it a ratio?
                    //Associated story:
                    // As a player, I want to be able to see a leaderboard that shows the top 20 players and their records, so that
                    //I can compare my progress with others.
                }
            }
        }
    }

    public  User[] getLeaderboard(){
        return leaderboard;
    }

    public static class Leaderboard {
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

        public String toString(){
            String output = "";
            for(int i = 0; i < leaderboard.size(); i++){
                output += "\n" + leaderboard.get(i).toString() + " W/L Ratio: " + leaderboard.get(i).getWinLossRatio();
            }
            return output;
        }
    }
}
