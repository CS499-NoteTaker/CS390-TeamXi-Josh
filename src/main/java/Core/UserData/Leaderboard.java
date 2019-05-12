package Core.UserData;
import java.util.*;
    public class Leaderboard {
        //Array used to Sort the leaderboard object
        private ArrayList<User> leaderboard;

        /**
         * Constructor for the leaderboaroard
         * @param users The Users that are apart of the leaderboard
         */
        public Leaderboard(UserList users){
            leaderboard = sortUsersByWinLossRatioHighestToLowest(users);
        }

        /**
         * Returns the leaderboard object
         * @return the leaderboard
         */
        public ArrayList<User> getLeaderboard(){
            return leaderboard;
        }

        /**
         * @return - Array of objects, each object a user, representing the leaderboard.
         */
        public Object[] getLeaderboardObjectArray(){
            return leaderboard.toArray();
        }

        /**
         * Sorts the Users By their win/loss ration with the Highest being at the top
         * @param users The Users of the Leader board
         * @return The List of users on the Leader board
         */
        public ArrayList<User> sortUsersByWinLossRatioHighestToLowest(UserList users){
            ArrayList<User> usersSorted = new ArrayList<User>();
            for(int i = 0; i < users.getSize(); i++){
                System.out.println("SORTING PROCESS: [" + i + "] " + users.getUserByIndex(i).getUserName());
                usersSorted = putUserInRightPlace(users.getUserByIndex(i), usersSorted);
            }
            return usersSorted;
        }

        /**
         * Puts a single user in the right part of the "sorted" userList based on W/L ratio
         * @return The ArrayList, with the user added to it
         */
        private ArrayList<User> putUserInRightPlace(User user, ArrayList<User> usersSorted){
            if(usersSorted.size() == 0){
                usersSorted.add(user);
            } else {
                int i = usersSorted.size() - 1;
                while(!usersSorted.contains(user) && (i >= 0)){
                    if(usersSorted.get(i).getWinLossRatio() <= user.getWinLossRatio()){
                        usersSorted.add(i + 1, user);
                    }
                    i--;
                }
            }
            return usersSorted;
        }

        public void addUserToLeaderboard(User user){
            leaderboard = putUserInRightPlace(user, leaderboard);
        }

        /**
         * Outputs a String with all the usernames and W/L ratios in order of Win Loss ratio, highest to lowest
         * @return The Leader board
        */
        public String toString(){
            StringBuilder build = new StringBuilder();
            for (int i = 0; i < leaderboard.size(); i++) {
                build.append(leaderboard.get(i).userName + ": " + leaderboard.get(i).getWin() + ' ');
            }
            return build.toString();
        }
    }

