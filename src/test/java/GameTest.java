import GameLogic.*;
import UserData.User;
import org.junit.*;

public class GameTest {


    User Spenser = new User("Spenser");
    User Josh = new User("Josh");
    User Sola = new User("Sola");
    User Holden = new User("Holden");
    Game testGame = new Game(Spenser, Josh);

    @Before
    public void before(){
    }

    @Test
    public void testGameConstructor01(){
        Game testGame2 = new Game(Spenser, Josh);
        Assert.assertEquals(Spenser, testGame2.getUser1());
    }

    @Test
    public void testGameConstructor02(){
        Game testGame3 = new Game(Spenser, Josh);
        Assert.assertEquals(Josh, testGame3.getUser2());
    }



    @Test
    public void testAssignPlayers01(){
        testGame.assignPlayers(Sola,Holden);
        Assert.assertEquals(Sola,testGame.getUser1());
    }

    @Test
    public void testAssignPlayers02(){
        testGame.assignPlayers(Sola,Holden);
        Assert.assertEquals(Holden,testGame.getUser2());
    }






}
