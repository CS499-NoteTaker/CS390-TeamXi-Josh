package GameLogic.Components;

//Initializes and stores all the gameboard Points in a 2-D array.
public class Board {
    private int boardSize = 19;
    private Point[][] board;

    /**
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

    /**
     * Returns a point from a given location on the board
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return a Point from the board
     */
    public Point getPointAtLocation(int x, int y){
        return board[x][y];
    }

    /**
     * Sets a piece on a point on a given location
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @param p the piece type, (B)lack, (W)hite, or (O)pen.
     */
    public void setPointAtLocation(int x, int y, Piece p){
        Point po = board[x][y];
        po.setOccupied();
        po.setPiece(p);
    }

    /**
     * prints the board to the command line, for Sprint 2 only.
     */
    public void printBoard(){
        System.out.print("  ");
        for(int i = 0; i < 19; i++){
            if(i < 10){
                System.out.print(" " + i + " ");
            }
            else{
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for(int i = 0; i  < 19; i++){
            if(i < 10){
                System.out.print(i + "  ");
            }
            else{
                System.out.print(i + " ");
            }
            for(int j = 0; j < 19; j++){
                Point temp;
                temp = this.getPointAtLocation(i, j);
                System.out.print(temp.getPiece() + "  ");

            }
            System.out.println();
        }
    }

    //Talking Points: Might consider adding an error throw for if there is more than one win combination for bug catching?...
    //Also this method shouldn't rely on the last move made so as to decrease dependencies,but this is also...
    //something we should discuss. Also what should the return value be? Can we determine the winner by...
    //checking if the returned value is true/false, then checking which player made the last move?
    /**
     * Prototype method, want to discuss the particulars with the group during the Sunday meeting
     * @return If there is a winning set on the board.
     */
    public boolean checkWinCondition(){
        return true;
    }
}