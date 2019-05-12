package Core.GameLogic;

public class Point {
    //Variables used to set pieces
    private int x, y;
    //Boolean used to tell if a piece is in a particular spot
    private boolean occupied;
    //the point should never be larger than the size of the board which is 19x19
    private final int boardSize = 19;
    private Piece piece;


    /**
     * Create a point object, this represents a location on the board. A board is made up of points.
     * @param x the x coordinate of the point object, must be 0 or greater (non-negative)
     * @param y the y coordinate of the point object, must be 0 or greater (non-negative)
     */
     public Point(int x, int y){
        if(invalidCoordinates(x, y)) {
            throw new IndexOutOfBoundsException("The coordinates must be non-negative and within board boundaries.");
        }

        this.x = x;
        this.y = y;
        this.occupied = false;
        this.piece = Piece.O;
    }

    /**
     * Insures that the coordinates are valid
     * Checks if the coordinates are within range of the board. They must be non-negative and less than or equal to 19.
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return true if the either of the coordinates are invalid
     */
     public boolean invalidCoordinates(int x, int y){
        return (x < 0 || x > boardSize) || (y < 0 || y > boardSize);
    }

    /**
     * Sets the occupation of the point, as needed
     */
     public void setOccupied(){
         this.occupied = !this.occupied;
    }

    /**
     * Checks if a point on the board has a piece on it or not
     * @return true if it has a piece, false if not
     */
    public boolean isOccupied(){
        return this.occupied;
    }

    /**
     * Get a piece from the board
     * @return the piece from a Point on the board
     */
    public Piece getPiece(){
        return this.piece;
    }

    /**
     * Set a piece on the board
     * @param P the color of the piece (or representing no piece)
     */
    public void setPiece(Piece P){
        this.piece = P;
    }

    /**
     * getX
     * @return the x coordinate of this
     */
    public int getX(){
        return this.x;
    }

    /**
     * getY
     * @return the y coordinate of this
     */
    public int getY(){
        return this.y;
    }

    /**
     * set the x coordinate of this
     * @param x the new x coordinate of this, must be greater than 0 (non-negative)
     */
    public void setX(int x){
        if(x < 0 && x <= boardSize) {
            throw new IndexOutOfBoundsException("The x coordinate must be non-negative and within board boundaries.");
        }

        this.x = x;
    }

    /**
     * set the y coordinate of this
     * @param y the new y coordinate of this, must be greater than 0, but no greater than 19 (non-negative)
     */
    public void setY(int y){
        if(y < 0 && y <= boardSize) {
            throw new IndexOutOfBoundsException("The y coordinate must be non-negative and within board boundaries.");
        }

        this.y = y;
    }

    /**
     * String representation of Point
     * @return's a string representation of a Point object
     */
    public String toString(){
        return this.x + " " + this.y;
    }
}


