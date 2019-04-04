package GameLogic.Components;

import UserData.User;

import java.sql.Time;
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
        return this.user.toString();
    }
    @Override
    public String toString() {
        return user.toString() + "\n" +
                "Point: (" + this.point.toString() + ")\n" +
                this.date.toString();
    }
}
