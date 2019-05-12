package Core.GameLogic;

import java.util.ArrayList;

public class MoveList {
    //Should it be some type of stack???
    private ArrayList<Move> moves; // Array List of moves


    /**
     *Base Constructor for creating a moveList
     */
    public MoveList (){
        moves = new ArrayList<Move>();
    }

    /**
     * Adds a move object to the moves ArrayList
     * @param move - a single Move object a user has made.
     */
    public void addMove( Move move) {
        moves.add( move );
    }

    /**
     * Clears the list of moves
     */
    public void clearMoves() {
        moves.clear();
    }


    public Move getFirstMove(){
        if( moves.size() == 0)
                return null;
        else
            return moves.get(0);
    }

    /**
     * Returns the String representation of the move List
     * @return String
     */
    @Override
    public String toString() {
        if( moves.isEmpty() )
            return "No moves in list";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moves.size(); i++) {
            sb.append( moves.get(i) );
            sb.append( "\n" );
        }
        return  sb.toString();
    }
}



