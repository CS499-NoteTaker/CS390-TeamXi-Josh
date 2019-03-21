import GameLogic.Components.Piece;
import org.junit.*;
import GameLogic.Components.Board;
import GameLogic.Components.Point;


public class BoardTest {
    private Point p1, p2, p3;
    private Board board;
    private Piece blackPiece = Piece.B;
    private Piece whitePiece = Piece.W;

    @Before
    public void setUp() {
        //create three points and a basic board
        p1 = new Point(0, 0);
        p2 = new Point(17, 17);
        p3 = new Point(12, 7);
        board = new Board();
    }

    @Test
    public void testCheckWinConditionForWhiteWin1(){  //(1, 1) --> (6, 1)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(i, 0, whitePiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForWhiteWin2(){  //(1, 1) --> (1, 6)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(1, i, whitePiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForWhiteWin3(){  //(1, 1) --> (6, 6)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(i, i, whitePiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForWhiteWin4(){  //(6, 1) --> (1, 6)
        for(int i = 1; i < 6; i++) {
            for(int j = 6; j > 1; j--){
                board.setPointAtLocation(i, j, whitePiece);
            }
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForWhiteWin5(){  //(6, 1) --> (1, 6)  w/black piece on either end
        board.setPointAtLocation(0, 7, blackPiece);
        board.setPointAtLocation(7, 0, blackPiece);
        for(int i = 1; i < 6; i++) {
            for(int j = 6; j > 1; j--){
                board.setPointAtLocation(i, j, whitePiece);
            }
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForWhiteWin6(){  //(1, 1) --> (1, 6)  w/black piece on either end
        board.setPointAtLocation(1, 0, blackPiece);
        board.setPointAtLocation(1, 7, blackPiece);
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(1, i, whitePiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin1(){  //(1, 1) --> (6, 1)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(i, 0, blackPiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin2(){  //(1, 1) --> (1, 6)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(1, i, blackPiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin3(){  //(1, 1) --> (6, 6)
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(i, i, blackPiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin4(){  //(6, 1) --> (1, 6)
        for(int i = 1; i < 6; i++) {
            for(int j = 6; j > 1; j--){
                board.setPointAtLocation(i, j, blackPiece);
            }
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin5(){  //(6, 1) --> (1, 6)  w/white piece on either end
        board.setPointAtLocation(0, 7, whitePiece);
        board.setPointAtLocation(7, 0, whitePiece);
        for(int i = 1; i < 6; i++) {
            for(int j = 6; j > 1; j--){
                board.setPointAtLocation(i, j, blackPiece);
            }
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForBlackWin6(){  //(1, 1) --> (1, 6)  w/white piece on either end
        board.setPointAtLocation(1, 0, whitePiece);
        board.setPointAtLocation(1, 7, whitePiece);
        for(int i = 1; i < 6; i++) {
            board.setPointAtLocation(1, i, blackPiece);
        }
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForNoWin(){  //All points on board are empty
        Assert.assertTrue(board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForNearWhiteWin(){  //(1, 1) --> (5, 5)
        for(int i = 1; i < 5; i++) {
            board.setPointAtLocation(i, i, whitePiece);
        }
        Assert.assertTrue(!board.checkWinCondition());
    }

    @Test
    public void testCheckWinConditionForNearBlackWin(){  //(1, 1) --> (5, 5)
        for(int i = 1; i < 5; i++) {
            board.setPointAtLocation(i, i, blackPiece);
        }
        Assert.assertTrue(!board.checkWinCondition());
    }

    @Test
    public void testPointOnBoard1(){
        Assert.assertTrue(comparePoints(board.getPointAtLocation(0, 0), p1));
    }

    @Test
    public void testPointOnBoard2(){
        Assert.assertTrue(comparePoints(board.getPointAtLocation(17, 17), p2 ));
    }

    @Test
    public void testSetPoint(){
        Point chosenPiece = board.getPointAtLocation(2, 2);
        System.out.println(chosenPiece.getPiece());
        chosenPiece.setPiece(Piece.B);
        Assert.assertEquals(2, board.getPointAtLocation(2, 2).getX());
    }

    public boolean comparePoints(Point p1, Point p2){
        return ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()));
    }

}

