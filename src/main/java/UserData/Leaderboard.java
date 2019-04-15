package UserData;
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
         * Sorts the Users By their win/loss ration with the Highest being at the top
         * @param users The Users of the Leader board
         * @return The List of users on the Leader board
         */
        private ArrayList<User> sortUsersByWinLossRatioHighestToLowest(UserList users){
            ArrayList<User> usersSorted = new ArrayList<User>();
            for(int i = 0; i < users.getSize(); i++){
                usersSorted = putUserInRightPlace(users.getUser(i), usersSorted);
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

        /**
         * Outputs the string representation of the Leader board
         * @return The Leader board

        */
        public StringBuilder leaderString(){
            StringBuilder build = new StringBuilder();
            for(int i = 0; i < leaderboard.size(); i++){
                build.append("\n" + leaderboard.get(i).getUserName());
            }
            return build;
        }
    }

