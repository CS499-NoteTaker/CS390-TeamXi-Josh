package GameLogic;

import UserData.User;

import java.util.Date;

public class Move {
    private User user;      // User that made the move
    private Date date;      // Date and time that user made move.
    private Point point;    // Point that user made a move on.

    // Constructor
    public Move (User u, Point p) {
        this.user = u;
        this.point = p;
        this.date = new Date(); // Grabs today's date.
    }

    /**
     * Gets the the user name of the person who made
     * this move.
     * @return String username
     */
    public String getWhoMoved() {
        return this.user.getUserName();
    }

    /**
     * Returns the String representation of a move in string format
     * @return string
     */
    @Override
    public String toString() {
        return user.getUserName() + "\n" +
                "Point: (" + this.point.toString() + ")\n" +
                this.date.toString();
    }

    public Point getPoint() {
        return point;
    }
}
