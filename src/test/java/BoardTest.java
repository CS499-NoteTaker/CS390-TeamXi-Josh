import GameLogic.Components.Piece;
import org.junit.*;
import GameLogic.Components.Board;
import GameLogic.Components.Point;


public class BoardTest {
    private Point p1, p2, p3;
    private Board board1, board2;
    private Piece blackPiece = Piece.B;
    private Piece whitePiece = Piece.W;

    @Before
    public void setUp() {
        //create three points and a basic board1
        p1 = new Point(0, 0);
        p2 = new Point(17, 17);
        p3 = new Point(12, 7);
        board1 = new Board();
        board2 = new Board();
    }


    @Test // Vertical White
    public void testCheckWinConditionForWhiteWin1(){
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(i, 0, whitePiece); //(1, 0) --> (6, 0)
            board2.setPointAtLocation(i, 18, whitePiece); //(1, 18) --> (6, 18)
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Horizontal White
    public void testCheckWinConditionForWhiteWin2(){
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(1, i, whitePiece); //(0, 1) --> (0, 6)
            board2.setPointAtLocation(18, i, whitePiece); //(18, 1) --> (18, 6)
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Diagonal Negative Slope White
    public void testCheckWinConditionForWhiteWin3(){  //(1, 1) --> (6, 6)
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(i - 1, i - 1, whitePiece);
            board2.setPointAtLocation(i + 12, i + 12, whitePiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Diagonal Positive Slope White
    public void testCheckWinConditionForWhiteWin4(){  //(6, 1) --> (1, 6)
        for(int i = 6; i >= 1; i--) {
            int j = 6-(i-1);
            board1.setPointAtLocation(i, j, whitePiece);
            board2.setPointAtLocation(i+11, j+11, whitePiece);
        }

        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Diagonal positive slope (black both ends)
    public void testCheckWinConditionForWhiteWin5(){  //(6, 1) --> (1, 6)  w/black piece on either end
        board1.setPointAtLocation(0, 7, blackPiece);
        board1.setPointAtLocation(7, 0, blackPiece);
        board2.setPointAtLocation(18, 13, blackPiece);
        board2.setPointAtLocation(13, 18, blackPiece);
        for(int i = 6; i >= 1; i--) {
            int j = 6-(i-1);
            board1.setPointAtLocation(i, j, whitePiece);
            board2.setPointAtLocation(i+11, j+11, whitePiece);
        }

        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Horizontal white (black both ends)
    public void testCheckWinConditionForWhiteWin6(){  //(1, 1) --> (1, 6)  w/black piece on either end
        board1.setPointAtLocation(1, 0, blackPiece);
        board1.setPointAtLocation(1, 7, blackPiece);
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(1, i, whitePiece);
            board2.setPointAtLocation(12, i+3, whitePiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test //Vertical black
    public void testCheckWinConditionForBlackWin1(){  //(1, 1) --> (6, 1)
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(i, 0, blackPiece);
            board2.setPointAtLocation(i, 18, blackPiece); //(1, 18) --> (6, 18)
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Horizontal Black
    public void testCheckWinConditionForBlackWin2(){  //(1, 1) --> (1, 6)
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(1, i, blackPiece);
            board2.setPointAtLocation(18, i, whitePiece); //(18, 1) --> (18, 6)
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Diagonal Negative Slope Black
    public void testCheckWinConditionForBlackWin3(){  //(1, 1) --> (6, 6)
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(i - 1, i - 1, blackPiece);
            board2.setPointAtLocation(i + 12, i + 12, blackPiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
        Assert.assertTrue(board2.checkWinCondition());
    }

    @Test // Diagonal Positive Slope Black
    public void testCheckWinConditionForBlackWin4(){  //(6, 1) --> (1, 6)
        for(int i = 6; i >= 1; i--) {
            int j = 6-(i-1);
            board1.setPointAtLocation(i, j, blackPiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
    }

    @Test // Diagonal Positive Slope Black (white both ends)
    public void testCheckWinConditionForBlackWin5(){  //(6, 1) --> (1, 6)  w/white piece on either end
        board1.setPointAtLocation(0, 7, whitePiece);
        board1.setPointAtLocation(7, 0, whitePiece);
        for(int i = 6; i >= 1; i--) {
            int j = 6-(i-1);
            board1.setPointAtLocation(i, j, blackPiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
    }

    @Test // Horizontal Black (white both ends)
    public void testCheckWinConditionForBlackWin6(){  //(1, 1) --> (1, 6)  w/white piece on either end
        board1.setPointAtLocation(1, 0, whitePiece);
        board1.setPointAtLocation(1, 7, whitePiece);
        for(int i = 1; i <= 6; i++) {
            board1.setPointAtLocation(1, i, blackPiece);
        }
        Assert.assertTrue(board1.checkWinCondition());
    }

    @Test // No points, No win
    public void testCheckWinConditionForNoWin(){  // All points on board1 are empty
        Assert.assertFalse(board1.checkWinCondition());
    }

    @Test // 5-row Diagonal Negative Slope White
    public void testCheckWinConditionForNearWhiteWin(){  //(1, 1) --> (5, 5)
        for(int i = 1; i <= 5; i++) {
            board1.setPointAtLocation(i, i, whitePiece);
        }
        Assert.assertTrue(!board1.checkWinCondition());
    }

    @Test // 5-row Diagonal Negative Slope Black
    public void testCheckWinConditionForNearBlackWin(){  //(1, 1) --> (5, 5)
        for(int i = 1; i <= 5; i++) {
            board1.setPointAtLocation(i, i, blackPiece);
        }
        Assert.assertTrue(!board1.checkWinCondition());
    }

    @Test // 5-row Vertical White
    public void testCheckWinConditionForNearWhiteWin1(){  //(1, 0) --> (6, 0)
        for(int i = 1; i <= 5; i++) {
            board1.setPointAtLocation(i, 0, whitePiece);
        }
        Assert.assertFalse(board1.checkWinCondition());
    }

    @Test // 5-row Horizontal White
    public void testCheckWinConditionForNearWhiteWin2(){  //(18, 1) --> (18, 6)
        for(int i = 1; i <= 5; i++) {
            board1.setPointAtLocation(18, i, whitePiece);
        }
        Assert.assertFalse(board1.checkWinCondition());
    }

    @Test
    public void testPointOnBoard1(){
        Assert.assertTrue(comparePoints(board1.getPointAtLocation(0, 0), p1));
        Assert.assertFalse(comparePoints(board1.getPointAtLocation(1, 0), p1));
        Assert.assertFalse(comparePoints(board1.getPointAtLocation(0, 1), p1));
    }

    @Test
    public void testPointOnBoard2(){
        Assert.assertTrue(comparePoints(board1.getPointAtLocation(17, 17), p2 ));
        Assert.assertFalse(comparePoints(board1.getPointAtLocation(16, 17), p2));
        Assert.assertFalse(comparePoints(board1.getPointAtLocation(17, 16), p2));
    }

    @Test
    public void testSetPoint(){
        Point chosenPiece = board1.getPointAtLocation(2, 2);
        chosenPiece.setPiece(Piece.B);
        Assert.assertEquals(2, board1.getPointAtLocation(2, 2).getX());
        Assert.assertEquals(2, board1.getPointAtLocation(2, 2).getY());
    }

    public boolean comparePoints(Point p1, Point p2){
        return ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()));
    }

}

