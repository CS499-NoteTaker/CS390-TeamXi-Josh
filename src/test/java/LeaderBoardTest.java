import GameLogic.Components.Point;
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
        UserList.addUser(chad);
        UserList.addUser(joe);
        UserList.addUser(adam);
    }

    @Test
    public void testLeaderBoard(){
        Assert.assertEquals(true, true);
    }
}
