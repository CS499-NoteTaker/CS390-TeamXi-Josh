package UserData;

import GameLogic.Game;

public class Controller {

    public static GameList gameList = new GameList();
    public static UserList userList = new UserList();


    public void createGame() {
        Game tempGame = new Game(new User("Josh"), new User("Daniel"));
        gameList.addGameToList(tempGame);
    }

    public void clearGames() {

    }

}