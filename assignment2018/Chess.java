package assignment2018;

import java.util.Scanner;

public class Chess 
{
    public static int[] convertCoords(String from, String to) 
    {
        if (from.length() == 2 && to.length() == 2)
        {
            int fromX = convertChar(from.charAt(0)) - 65;
            int fromY = from.charAt(1) - 49;
            int toX = convertChar(to.charAt(0)) - 65;
            int toY = to.charAt(1) - 49;
            int[] jump = {fromX, fromY, toX, toY};
            return jump;
        }
        return null;
    }
    
    public static char convertChar(char character) {return character;}
    
	public static void main(String[] args) 
	{
		//construct board
		Board board = new Board();
		
		//construct 2 players
		
		//construct display
		TextDisplay display = new TextDisplay();
		
		String from = "";
		String to = "";
		Scanner scanner = new Scanner(System.in);
		boolean capture;
		int[] jump;
		boolean legal;
		Move move;
		
		System.out.println(board.occupied(5, 6));
		System.out.println(board.getPiece(5, 6).getColourChar() + " " + board.getPiece(5, 6)); //needs adding a NullExceptionError in case no piece found
		
		//Game loop ending if a king is taken 
		do 
		{
		    updateDisplay(display, board);
		    legal = false; //reset legal (just in case) 
		    //- request moves loop ("to" , "from")
		    do
		    {
		        from = scanner.next();
		        to = scanner.next();
		    }
		    while (convertCoords(from, to) == null);
		    jump = convertCoords(from, to);
		    //for (int i : jump) {System.out.println(i);} //prints out move in coordinate form as array
		    
		    if (board.getBoard().occupied(jump[2],jump[3])) {capture = true;}
		    else {capture = false;}
		    //new Move(board.getPiece(jump[0], jump[1]), jump[0], jump[1], jump[2], jump[3], capture);
		    

		    //Black Pawn F7 to F6
		    move = new Move(board.getPiece(5, 6), 5, 6, 5, 4, false);
		    legal = move.testMove(board);

		    //White Pawn G1 to G3
		    move = new Move(board.getPiece(6, 1), 6, 1, 6, 3, false);
		    legal = move.testMove(board);

		    //Black Pawn take White Pawn
		    move = new Move(board.getPiece(5, 4), 5, 4, 6, 3, true);
		    legal = move.testMove(board);

		    //System.out.println("Piece at 5, 6: " + board.getPiece(5, 6));
		    //System.out.println("Piece at 5, 5: " + board.getPiece(5, 5));
		    
		    System.out.println(board.getWhite().getNumPieces());
		    System.out.println(board.getBlack().getNumPieces());
		    
				//get piece
				//check valid move
		
			//update display
		}
		while (!kingTaken());
		
		scanner.close();
	}
	
	private static boolean kingTaken() {return false;} //temporary method
	private static void updateDisplay(TextDisplay display, Board board) 
	{          
	    display.addPieces(board.getWhite());
	    display.addPieces(board.getBlack());
	    display.displayBoard(board.getWhite()); //shouldn't need the pieces to display the board.
	}
}
