package GameLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class GameList implements Serializable {
    ArrayList<Game> Games = new ArrayList<>();

    public GameList(){

    }
    public void addGameToList(Game g){
        Games.add(g);
    }
}
