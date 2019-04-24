import GameLogic.Point;
import UserData.Leaderboard;
import UserData.User;
import UserData.UserList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;

public class LeaderBoardTest {
    private Leaderboard leaderboard;
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
        userList.addUser(joe);
        userList.addUser(adam);
        userList.addUser(chad);
        System.out.println("UserList Contents:   " + userList.toString());

        this.leaderboard = new Leaderboard(userList);
;    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("Kaitlyn Spenser Sola Holden Josh Joe Adam Chad ", leaderboard.toString());
    }
}
