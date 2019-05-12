import Core.GameLogic.Game;
import Core.UserData.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    User Kaitlyn;

    @Before
    public void setup(){
         Kaitlyn = new User("Kaitlyn");
    }

    @Test
    public void testUser(){
        Assert.assertEquals("Kaitlyn", Kaitlyn.getUserName());
    }

    @Test
    public void testWin(){
        Kaitlyn.addWin();
        Assert.assertEquals(1, Kaitlyn.getWin());
    }

    @Test
    public void testLoss(){
        Kaitlyn.addLoss();
        Assert.assertEquals(1, Kaitlyn.getLoss());
    }

    @Test
    public void constructorTest01(){
        User Spenser = new User("Spenser");
        Assert.assertEquals(Spenser,Spenser);
    }

    @Test
    public void AddGameTest01(){
        User Spenser = new User("Spenser");
        User Sola = new User("Sola");
        Game TestGame = new Game(Spenser,Sola);
        Spenser.addGame(TestGame);
        Assert.assertEquals(Spenser.getCurrentGameAtIndex(0),
                Spenser.getCurrentGameAtIndex(0));
    }
    @Test
    public void addWinTest01(){
        User Spenser = new User("Spenser");
        Spenser.addWin();
        Assert.assertEquals(1, Spenser.getWin());
    }

    @Test
    public void addLossTest01(){
        User Spenser = new User("Spenser");
        Spenser.addLoss();
        Assert.assertEquals(1, Spenser.getLoss());
    }

    @Test
    public void getWinTest01(){
        User Spenser = new User("Spenser");
        Spenser.addWin();
        Spenser.addLoss();
        Spenser.addLoss();
        double WL = 0.5;
        Assert.assertEquals(WL, Spenser.getWinLossRatio(),1);
    }

    @Test
    public void getUserNameTest01(){
        User Spenser = new User("Spenser");
        Assert.assertEquals("Spenser", Spenser.getUserName());
    }

    @Test
    public void UsernameEquals01(){
        User Spenser = new User("Spenser");
        Assert.assertFalse(Spenser.usernameEquals("joe"));
    }

    @Test
    public void GetCurrentGames01(){
        User Spenser = new User("Spenser");
        User Sola = new User("Sola");
        Game TestGame = new Game(Spenser,Sola);
        Spenser.addGame(TestGame);
        Assert.assertNotEquals(null, Spenser.getCurrentGames());
    }




}
