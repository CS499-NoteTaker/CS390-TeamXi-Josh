package Core.UserData;

import Core.GameLogic.Game;

import java.util.ArrayList;

public class GameList {
    //The List of all Games
    public ArrayList<Game> games;

    public GameList() {
        games = new ArrayList<>();
        /*Game test = new Game(Controller.userList.getUserByUsername("Kaitlyn"), Controller.userList.getUserByUsername("Sola"));
        games.add(test);*/
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
     * Returns A specific game given a index
     * @param i index
     * @return Game object
     */
    public Game getGameAtIndex(int i){
        return games.get(i);
    }

    public int getSize(){return games.size();}
}
