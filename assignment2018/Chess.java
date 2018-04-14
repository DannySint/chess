package assignment2018;
import assignment2018.codeprovided.*;

public class Chess 
{

	public static void main(String[] args) 
	{
		//construct board
		Board board = new Board();
		
		//create pieces
		Pieces shiro = new Pieces(board, 'w'); //white
		Pieces kuro = new Pieces(board, 'b'); //black
		
		//construct 2 players
		
		//construct display
		TextDisplay display = new TextDisplay(shiro);
		
		//System.out.println(shiro.getNumPieces());
		
		//do while game loop if (kingTaken)
			//- request moves loop ("to" , "from")
			
				//get piece
				//check valid move
		
			//update display
	}

}
