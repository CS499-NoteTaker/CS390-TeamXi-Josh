import Core.GameLogic.Move;
import Core.GameLogic.Point;
import Core.UserData.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class MoveTest {


    @Test
    public void constructorTest01(){
        User Spenser = new User("Spenser");
        Move first = new Move(Spenser, new Point(2,5));
        Assert.assertEquals("Spenser", first.getWhoMoved());
    }
    @Test
    public void toStringTest01(){
        User Spenser = new User("Spenser");
        Move first = new Move(Spenser, new Point(5,4));
        Assert.assertEquals(Spenser.getUserName() + "\n" +
                "Point: (" + first.getPoint().toString() + ")\n" +
                new Date().toString(),first.toString());
    }
}
