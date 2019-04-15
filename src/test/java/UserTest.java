import UserData.User;
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


}
