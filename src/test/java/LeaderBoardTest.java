import GameLogic.Point;
import UserData.Leaderboard;
import UserData.User;
import UserData.UserList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeaderBoardTest {

    @Before
    public void setUp(){
        User joe = new User("Joe");  //0.0
        joe.addLoss();
        User adam = new User("Adam"); //1.0
        adam.addLoss();
        adam.addWin();
        User chad = new User("Chad"); //2.0
        chad.addWin();
        chad.addWin();
        chad.addLoss();
        UserList userList = new UserList();
        userList.addUser(chad);
        userList.addUser(joe);
        userList.addUser(adam);

        Leaderboard lead = new Leaderboard(userList);
        String uList = lead.leaderString().toString();
        System.out.println(uList);
        System.out.println("k");
    }

    @Test
    public void testLeaderBoard()
    {
        Assert.assertEquals(true, true);
    }
}
