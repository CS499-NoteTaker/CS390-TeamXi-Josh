package ConnectSix.GameLogic;

public class Game {
    private boolean play = true;

    public static void main(String args[]){
        Board gameBoard = new Board();
        gameBoard.printBoard();

        /*
        Point p = new Point(3, 2);
        System.out.println(p);

        Point chosenPiece = gameBoard.getPointAtLocation(2, 2);
        System.out.println(chosenPiece.getPiece());
        chosenPiece.setPiece(Piece.B);
        System.out.println(chosenPiece.getPiece());
        gameBoard.setPointAtLocation(2, 2, chosenPiece.getPiece());

        System.out.println(gameBoard.getPointAtLocation(2, 2));

        gameBoard.printBoard();*/

    }
    public void play(){
        Board gameBoard = new Board();
        //System.out.print("Welcome to Connect Six!");
        //welcome message
        //create a user --> USER CLASS
        //create a new game (or choose from a list)?
        while(play){

        }
        //initialize board
        //loop to allow game to be played until gameIsWon or similar method
    }
}
