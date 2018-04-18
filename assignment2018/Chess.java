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
		int turnNumber = 1;
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
		int x, y = 0;
		
		//Game loop ending if a king is taken 
		do 
		{
		    updateDisplay(display, board);
		    legal = false; //reset legal (just in case)
		    //- request moves loop ("to" , "from")
		    do
		    {
		        from = "h2"; to = "h2";
		        //from = scanner.next(); to = scanner.next();
		    }
		    while (convertCoords(from, to) == null);
		    jump = convertCoords(from, to);
		    //for (int i : jump) {System.out.println(i);} //prints out move in coordinate form as array
		    
		    if (board.getBoard().occupied(jump[2],jump[3])) {capture = true;}
		    else {capture = false;}
		    //new Move(board.getPiece(jump[0], jump[1]), jump[0], jump[1], jump[2], jump[3], capture);
		    
		    
		    switch (turnNumber)
		    {
		       case 1: 
		           //Pawn E1 to E3
		           x=4; y=1;
		           move = new Move(board.getPiece(x, y), x, y, 4, 3, false);
		           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		           if (board.getPiece(move.getX(), move.getY()) != null)
		           {
		               legal = move.movePiece(board);
		               if (legal) 
		                   {board.getPiece(x, y).setPosition(4, 3);}
		           }
		      break;
		      
		      case 2: 
		           //Bishop F0 to E1
		           x=5; y=0;
		           move = new Move(board.getPiece(x, y), x, y, 4, 1, false);
		           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		           if (board.getPiece(move.getX(), move.getY()) != null)
		           {
		               legal = move.movePiece(board);
		               System.out.println("Legal: " + legal);
		               if (legal) 
		                   {board.getPiece(x, y).setPosition(4, 1);}
		           }
		       break;
		       
		      case 3: 
		          //Bishop E1 to C3
		          x=4; y=1;
		          move = new Move(board.getPiece(x, y), x, y, 2, 3, false);
		          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		          if (board.getPiece(move.getX(), move.getY()) != null)
		          {
		              legal = move.movePiece(board);
		              System.out.println("Legal: " + legal);
		              if (legal) 
		                  {board.getPiece(x, y).setPosition(2, 3);}
		          }
		      break;
		      
		      case 4: 
		          //Bishop C3 to B4
		          x=2; y=3;
		          move = new Move(board.getPiece(x, y), x, y, 1, 4, false);
		          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		          if (board.getPiece(move.getX(), move.getY()) != null)
		          {
		              legal = move.movePiece(board);
		              System.out.println("Legal: " + legal);
		              if (legal) 
		                  {board.getPiece(x, y).setPosition(1, 4);}
		          }
		      break;
		      
		      case 5: 
		          //Bishop B4 to D6
		          x=1; y=4;
		          move = new Move(board.getPiece(x, y), x, y, 3, 6, false);
		          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		          if (board.getPiece(move.getX(), move.getY()) != null)
		          {
		              legal = move.movePiece(board);
		              System.out.println("Legal: " + legal);
		              if (legal) 
		                  {board.getPiece(x, y).setPosition(3, 6);}
		          }
		          System.out.println(board.getBlack().getNumPieces());
		          System.out.println(board.getWhite().getNumPieces());
		      break;
		      
		      case 6:
		          //Bishop D6 to B4
		          x=3; y=6;
		          move = new Move(board.getPiece(x, y), x, y, 1, 4, false);
		          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
		          if (board.getPiece(move.getX(), move.getY()) != null)
		          {
		              legal = move.movePiece(board);
		              System.out.println("Legal: " + legal);
		              if (legal) 
		                  {board.getPiece(x, y).setPosition(1, 4);}
		          }
		      break;
		    }
	        turnNumber = turnNumber(turnNumber);
		}
		//while (!kingTaken());
		while (turnNumber(turnNumber) <= 10);
		
		scanner.close();
	}
	
	private static boolean kingTaken() {return false;} //temporary method
	private static int turnNumber(int turnNumber) {turnNumber++; return turnNumber;}
	private static void updateDisplay(TextDisplay display, Board board) 
	{          
	    display.addPieces(board.getWhite());
	    display.addPieces(board.getBlack());
	    display.displayBoard(board.getWhite()); //shouldn't need the pieces to display the board.
	}
}
