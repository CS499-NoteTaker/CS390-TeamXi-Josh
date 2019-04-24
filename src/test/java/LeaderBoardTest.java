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
//TODO: make leaderboard work
    @Before
    public void setUp(){
        User joe = new User("Joe");  //0.0
//        joe.addLoss();
//        User adam = new User("Adam"); //1.0
//        adam.addLoss();
//        adam.addWin();
//        User chad = new User("Chad"); //2.0
//        chad.addWin();
//        chad.addWin();
//        chad.addLoss();
        UserList userList = new UserList();
//        userList.addUser(chad);
        userList.addUser(joe);
//        userList.addUser(adam);
        System.out.println("UserList Contents:   " + userList.toString());

        this.leaderboard = new Leaderboard(userList);
        //System.out.println("leaderboardAtIndexZero: " + leaderboard.getUsernameAtIndex(0));
;    }

    @Test
    public void testToString()
    {
        Assert.assertEquals(leaderboard.toString(), "");
    }
}
