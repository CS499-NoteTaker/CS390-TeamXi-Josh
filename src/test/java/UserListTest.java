import UserData.*;
import org.junit.*;

public class UserListTest {
    UserList users;
    @Before
    public void setUp(){
       users = new UserList();
       users.addUser(new User("Kaitlyn"));
       users.addUser(new User("Hanz"));
       users.addUser(new User("Gabriel"));
    }

   /* @Test
    public void testGetAllUsers(){
        Assert.assertEquals("", users.getAllUsers());
    }*/
/*
    @Test
    public void testGetUser(){
        Assert.assertEquals("Kaitlyn", users.getUser(0).getUserName());
    }*/

   /* @Test
    public void testAddUser(){
        users.addUser(new User("Lucas"));
        Assert.assertEquals(4, users.getSize());
    }*/

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
