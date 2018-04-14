package assignment2018;
import assignment2018.codeprovided.*;

public class TextDisplay implements Display
{

	@Override
	public void displayBoard(Pieces myPieces) 
	{
		System.out.println(" |ABCDEFGH");
		System.out.println("----------");
		for (int piece = 0; piece < myPieces.getNumPieces(); piece++)
		{
			//System.out.println(myPieces.getPiece(i));
		}
	}
	
	public static void main(String[] args) 
	{
		Board board = new Board();
		Pieces myPieces = new Pieces(board, 0);
		
		TextDisplay display = new TextDisplay();
		display.displayBoard(myPieces);
	}

}
