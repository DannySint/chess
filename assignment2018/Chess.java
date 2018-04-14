package assignment2018;
import assignment2018.codeprovided.*;

public class Chess 
{

	public static void main(String[] args) 
	{
		//construct board
		Board board = new Board();
		
		//construct 2 players
		
		//construct display
		TextDisplay display = new TextDisplay();
		
		
		
		//System.out.println(shiro.getNumPieces());
		
		//do while game loop if (kingTaken)
		    display.addPieces(board.getWhite());
		    display.addPieces(board.getBlack());
        
		    display.displayBoard(board.getWhite()); //shouldn't need the pieces to display the board.
			//- request moves loop ("to" , "from")
			
				//get piece
				//check valid move
		
			//update display
	}

}
