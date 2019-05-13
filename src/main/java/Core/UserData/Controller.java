package Core.UserData;

import Core.GameLogic.Game;
import Core.GameLogic.Piece;

public class Controller {

    public static GameList gameList = new GameList();
    public static UserList userList = new UserList();

    public static void createGame() {
        Game tempGame = new Game(Controller.userList.getUserByUsername("Josh"), Controller.userList.getUserByUsername("Kaitlyn"));
        gameList.addGameToList(tempGame);

        Game tempGame2 = new Game(Controller.userList.getUserByUsername("Kaitlyn"), Controller.userList.getUserByUsername("Spenser"));
        tempGame2.play = false;
        gameList.addGameToList(tempGame2);
    }

    public void clearGames() {

    }

}
