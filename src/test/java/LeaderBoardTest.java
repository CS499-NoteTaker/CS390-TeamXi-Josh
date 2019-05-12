
import Core.UserData.Leaderboard;
import Core.UserData.User;
import Core.UserData.UserList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        userList.addUser(adam);
        userList.addUser(joe);
        userList.addUser(chad);

        this.leaderboard = new Leaderboard(userList);
;    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("Kaitlyn: 3 Spenser: 3 Sola: 2 Holden: 2 Josh: 2 Joe: 0 Adam: 1 Chad: 2 ", leaderboard.toString());
    }
}
