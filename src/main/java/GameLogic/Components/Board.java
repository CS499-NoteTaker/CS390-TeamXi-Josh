package GameLogic.Components;

import java.util.ArrayList;

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

    /**
     * Evaluates entirety of the board to ascertain if there is a winning combination on the board. PROTOTYPE
     * @return If there is a winning set on the board.
     */
    public boolean checkWinCondition(){
        //get all the rows
        ArrayList<Point[]> rows = new ArrayList<>();
        for(int i = 0; i < boardSize; i++){
            rows.add(getRowOfPoints(i));
        }
        //get all the columns
        ArrayList<Point[]> columns = new ArrayList<>();
        for(int i = 0; i < boardSize; i++) {
            columns.add(getColumnOfPoints(i));
        }
        //get all the diagonals
        ArrayList<Point[]> diagonals = new ArrayList<>();
        // Redundancy warning: gets diagonal from (0, 0) twice
        for(int i = 0; i < boardSize - 5; i++) {
            diagonals.add(getDiagonalNegativeSlopePoints(0, i));
            diagonals.add(getDiagonalNegativeSlopePoints(i, 0));
        }

        // Evaluate all the ArrayLists for a winning combination, if EITHER direction
        // has a 6-in-a-row
        return (checkAggregatePointArrayListForWins(rows)
                || checkAggregatePointArrayListForWins(columns)
                || checkAggregatePointArrayListForWins(diagonals));
    }

    /**
     * Checks and ArrayList of arrays of Point objects for any winning runs
     * @param aggregateArrayList - An ArrayList of arrays of Point objects
     * @return true if there is a winning run
     */
    private boolean checkAggregatePointArrayListForWins(ArrayList<Point[]> aggregateArrayList){
        for(int i = 0; i < aggregateArrayList.size(); i++){
            if(checkSixInARow(aggregateArrayList.get(i))){ return true; }
        }
        return false;
    }

    /**
     *  Checks an array of Point objects for a run of 5 same-colored Pieces
     * @param points An ordered array of Point objects
     * @return true if there is a run of 5
     */
    private boolean checkSixInARow(Point[] points){
        int counter = 1;
        for(int i = 1; i < points.length; i++) {
            try {
                if ((points[i - 1].getPiece() != points[i].getPiece()) || (points[i].getPiece() == Piece.O)) {
                    counter = 1;
                } else {
                    counter++;
                }
                if (counter == 6) {
                    return true;
                }
            } catch (Exception e){

            }
        }
        return false;
    }

    /**
     * Gets a row of Point objects given a y coordinate
     * @param y - a y value on the board
     * @return An array of Point objects
     */
    private Point[] getRowOfPoints(int y){
        Point[] points = new Point[boardSize];
        for(int i = 0; i < boardSize; i++){
            points[i] = getPointAtLocation(i, y);
        }
        return points;
    }

    /**
     * Gets a column of Point objects given an x coordinate
     * @param x - an x value on the board
     * @return An array of Point objects
     */
    private Point[] getColumnOfPoints(int x){
        Point[] points = new Point[boardSize];
        for(int i = 0; i < boardSize; i++){
            points[i] = getPointAtLocation(x, i);
        }
        return points;
    }

    /**
     * Gets a diagonal of Point objects in a NEGATIVE SLOPE direction.
     * @param x - an X-value, should be zero if the other is non-zero
     * @param y - a Y-value, should be zero if the other is non-zero
     * @return An array of Point objects
     */
    private Point[] getDiagonalNegativeSlopePoints(int x, int y){
        Point[] points = new Point[boardSize - x - y];
        for(int i = 0; i < points.length; i++){
            points[i] = getPointAtLocation(x + i, y + i);
        }
        return points;
    }

    /**
     * Gets a diagonal of Point objects going North and West of the given coordinate
     * @param x - an X-value, should be zero if the other is non-zero
     * @param y - a Y-value, should be zero if the other is non-zero
     * @return An array of Point objects
     */
    private Point[] getSouthWestDiagonalOfPoints(int x, int y){
        Point[] points = new Point[boardSize];
        for(int i = 0; i < x + y; i++){
            System.out.println((x - i) + ", " + (y + i) + "  x = " + x + " y = " + y);
            points[i] = getPointAtLocation(x - i, y + i);
        }
        return points;
    }
}