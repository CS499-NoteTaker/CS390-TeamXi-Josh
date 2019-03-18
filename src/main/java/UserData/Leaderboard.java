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
}
