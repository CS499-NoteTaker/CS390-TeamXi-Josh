package GameLogic;

/**
 * Piece is used as a flag for the board as a representation of if the point on the board is filled
 */
public enum Piece {
    O {
        @Override
        public String toString() {
            return "O";
        }
    },

    B {
        @Override
        public String toString() {
            return "B";
        }
    },

    W {
        @Override
        public String toString() {
            return "W";
        }
    }
}