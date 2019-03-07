package ConnectSix.GameLogic;

//Initializes and stores all the gameboard Points in a 2-D array.
public class Board {
    private int boardSize = 19;
    private Point[][] board;

    /*
     * Creates a new Board Object which instantiates a 2-D array of Point objects.
     */
    public Board(){
        board = new Point[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                Point p = new Point(i, j);
                board[i][j] = p;
            }
        }
    }

    public Point getPointAtLocation(int x, int y){
        return board[x][y];
    }
}