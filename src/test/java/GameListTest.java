import Core.GameLogic.Game;
import Core.UserData.GameList;
import Core.UserData.User;
import org.junit.Assert;
import org.junit.Test;

public class GameListTest {

    @Test
    public void GameListConstructorTest01(){
        GameList allGames = new GameList();
        Assert.assertFalse(allGames == null);
    }

    @Test
    public void AddGamesTest01(){
        GameList allGames = new GameList();
        User Spenser = new User("Spenser");
        User Sola = new User("Sola");
        Game first = new Game(Spenser, Sola);
        allGames.addGameToList(first);
        Assert.assertEquals(allGames.getGameAtIndex(0), allGames.getAllGames().get(0));
    }

    @Test
    public void AddGamesTest02(){
        GameList allGames = new GameList();
        User Spenser = new User("Spenser");
        User Sola = new User("Sola");
        Game first = new Game(Spenser, Sola);
        allGames.addGameToList(first);
        Assert.assertEquals(allGames.getAllGames().get(0), allGames.getGameAtIndex(0));

    }
    @Test
    public void getSizeTest01(){
        GameList allGames = new GameList();
        User Spenser = new User("Spenser");
        User Sola = new User("Sola");
        Game first = new Game(Spenser, Sola);
        allGames.addGameToList(first);
        Assert.assertEquals(1,allGames.getSize());
    }
}
