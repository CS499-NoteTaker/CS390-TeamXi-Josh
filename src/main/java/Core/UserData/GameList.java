package Core.UserData;

import Core.GameLogic.Game;

import java.util.ArrayList;

public class GameList {
    //The List of all Games
    public ArrayList<Game> games = new ArrayList<>();

    public GameList() {
        User Kaitlyn = Controller.userList.getUserByUsername("Kaitlyn");
        User Sola = Controller.userList.getUserByUsername("Sola");

        Game test = new Game(Kaitlyn, Sola);
        games.add(test);
    }

    /**
     * Adds the given game into the List of games
     * @param g Game to add
     */
    public void addGameToList(Game g){
        games.add(g);
    }


    /**
     * Returns EveryGame That is held in the Games List
     * @return ArrayList<Game> Holds all the Games</Game>
     */
    public ArrayList<Game> getAllGames(){
        return games;
    }

    /**
     * Traverses through a list of games and returns a list of games
     * that have the userName String at any point
     * @param userName - string user name
     * @return - list of games with user name in it
     */
    public ArrayList<Game> getAllUserGames( String userName ) {
        ArrayList<Game> userGames = new ArrayList<>();
        Game tempGame;
        User tempUser1, tempUser2;

        // Traverses through the gameList ArrayList.
        // to get games that has userName
        for (int i = 0; i < games.size(); i++ ) {
            tempGame = games.get(i);
            tempUser1 = tempGame.getUser1();
            tempUser2 = tempGame.getUser2();

            // If userName is player 1 or 2.
            if ( tempUser1.getUserName().equals(userName) || tempUser2.getUserName().equals(userName)  )
                userGames.add(tempGame);
        }

        return userGames;
    }


    /**
     * Returns A specific game given a index
     * @param i index
     * @return Game object
     */
    public Game getGameAtIndex(int i){
        return games.get(i);
    }

    public int getSize(){return games.size();}
}
