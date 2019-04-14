package GameLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable {
    ArrayList<Game> Games = new ArrayList<>();

    public GameList(){

    }

    /**
     * Adds the given game into the List of games
     * @param g Game to add
     */
    public void addGameToList(Game g){
        Games.add(g);
    }
}
