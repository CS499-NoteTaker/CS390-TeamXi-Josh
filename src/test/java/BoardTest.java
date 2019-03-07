import org.junit.*;
import ConnectSix.GameLogic.Board;
import ConnectSix.GameLogic.Point;

public class BoardTest {
    private Point p1;
    private Point p2;
    private Point p3;
    private Board board;

    @Before
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(17, 17);
        p3 = new Point(12, 7);
        board = new Board();
    }

    @Test
    public void testPointOnBoard1(){
        Assert.assertTrue(comparePoints(board.getPointAtLocation(0, 0), p1));
    }

    @Test
    public void testPointOnBoard2(){
        Assert.assertTrue(comparePoints(board.getPointAtLocation(17, 17), p2 ));
    }
    

    public boolean comparePoints(Point p1, Point p2){
        return ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()));
    }

}

