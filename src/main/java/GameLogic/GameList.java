package GameLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable {
    //The List of all Games
    public static ArrayList<Game> Games = new ArrayList<>();

    public GameList(){

    }

    /**
     * Adds the given game into the List of games
     * @param g Game to add
     */
    public void addGameToList(Game g){
        Games.add(g);
    }


    /**
     * Returns EveryGame That is held in the Games List
     * @return ArrayList<Game> Holds all the Games</Game>
     */
    public ArrayList<Game> getAllGames(){
        return Games;
    }

    /**
     * Returns A specific game given a index
     * @param i index
     * @return Game object
     */
    public Game getGameAtIndex(int i){
        return Games.get(i);
    }
}
