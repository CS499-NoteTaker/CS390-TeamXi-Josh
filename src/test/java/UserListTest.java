import UserData.*;
import org.junit.*;

public class UserListTest {
    UserList users;
    @Before
    public void setUp(){
       users = new UserList();
    }

    @Test
    public void testGetAllUsers(){
        Assert.assertEquals("Kaitlyn Spenser Sola Holden Josh ", users.toString());
    }

    @Test
    public void testGetUser1(){
        Assert.assertEquals("Kaitlyn", users.getUser(0).getUserName());
    }

    @Test
    public void testGetUser2() { Assert.assertEquals("Spenser", users.getUser(1).getUserName()); }


    @Test
    public void testFindUser(){
        Assert.assertEquals("Kaitlyn", users.findUser("Kaitlyn").getUserName());
    }

    @Test
    public void testContains(){
        Assert.assertEquals(true, users.contains("Spenser"));
    }

    @Test
    public void testSize(){
        Assert.assertEquals(5, users.getSize());
    }
}
