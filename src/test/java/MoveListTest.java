import GameLogic.Move;
import GameLogic.MoveList;
import GameLogic.Point;
import UserData.User;
import org.junit.Assert;
import org.junit.Test;

public class MoveListTest {

    @Test
    public void constructorTest01(){
        MoveList all = new MoveList();
        User Spenser = new User("Spenser");
        Point first = new Point(5,6);
        Move startingMove = new Move(Spenser, first);
        all.addMove(startingMove);
        Assert.assertEquals(all.getFirstMove().toString(),startingMove.toString());
    }

    @Test
    public void clearMovesTest01(){
        MoveList all = new MoveList();
        User Spenser = new User("Spenser");
        Point first = new Point(3,7);
        Move StartMove = new Move(Spenser,first);
        all.addMove(StartMove);
        all.clearMoves();
        Assert.assertEquals(null, all.getFirstMove());
    }

    //Only Tests when MoveList is empty
    @Test
    public void toStringTest01(){
        MoveList all = new MoveList();
        Assert.assertEquals("No moves in list", all.toString());

    }
    @Test
    public void addMoveTest(){
        MoveList all = new MoveList();

    }
}
