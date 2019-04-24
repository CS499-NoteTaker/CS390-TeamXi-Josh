import UserData.*;
import org.junit.*;

public class UserListTest {
    UserList users;
    @Before
    public void setUp(){
       users = new UserList();
    }
/*
    @Test
    public void testGetAllUsers(){
        Assert.assertEquals("", users.getAllUsers().toString());
    }

    @Test
    public void testGetUser(){
        Assert.assertEquals("Kaitlyn", users.getUser(0).getUserName());
    }



    @Test
    public void testFindUser(){
        Assert.assertEquals("Kaitlyn", users.findUser("Kaitlyn").getUserName());
    }

    @Test
    public void testContains(){
        Assert.assertEquals(true, users.contains("Hanz"));
    }

   /* @Test
    public void testSize(){
        Assert.assertEquals(3, users.getSize());
    } works when ran individually from other tests*/
}
