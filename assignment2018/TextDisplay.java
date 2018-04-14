package assignment2018;
import assignment2018.codeprovided.*;

public class TextDisplay implements Display
{

    private char[][] board;
    
    public TextDisplay(Pieces myPieces)
	{
	    displayBoard(myPieces);
	}
	
    @Override
    public void displayBoard(Pieces myPieces) 
    {
        System.out.println(" |ABCDEFGH");
        System.out.println("----------");
        System.out.println(myPieces.getNumPieces());
        
        char[][] board = new char[8][8];
        
        for (int piece = 0; piece < myPieces.getNumPieces(); piece++)
        {
            //System.out.println(myPieces.getPiece(piece));
            board[myPieces.getPiece(piece).getX()][myPieces.getPiece(piece).getY()] = myPieces.getPiece(piece).getChar(); 
	    }
        
        //display board loops
        for (int i = 0; i < 8; i++) 
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
	}
    

    public static void main(String[] args) 
    {
        Board board = new Board();
        Pieces myPieces = new Pieces(board, 0);

        TextDisplay display = new TextDisplay(myPieces);
        display.displayBoard(myPieces);
    }
}
