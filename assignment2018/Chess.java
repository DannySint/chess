package assignment2018;
import assignment2018.codeprovided.*;

public class Chess 
{

	public static void main(String[] args) 
	{
		//construct board
		Board board = new Board();
		
		//create pieces
		Pieces shiro = new Pieces(board, 0); //white
		Pieces kuro = new Pieces(board, 1); //black
		
		//construct 2 players
		
		//construct display
		TextDisplay display = new TextDisplay();
		
		display.addPieces(shiro);
		display.addPieces(kuro);
		
		display.displayBoard(kuro); //shouldn't need the pieces to display the board.
		
		//System.out.println(shiro.getNumPieces());
		
		//do while game loop if (kingTaken)
			//- request moves loop ("to" , "from")
			
				//get piece
				//check valid move
		
			//update display
	}

}
