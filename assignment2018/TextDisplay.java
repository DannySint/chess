package assignment2018;
import assignment2018.codeprovided.*;

public class TextDisplay implements Display
{

    private char[][] board;
    
    public TextDisplay() 
    {
        board = new char[8][8];
        for (int row = 0; row < 8; row++) 
        {
            for (int col = 0; col < 8; col++)
            {
                board[col][row] = '.';
            }
            
        }
    }
	
    
    public void addPieces(Pieces myPieces)
    {
        for (int piece = 0; piece < myPieces.getNumPieces(); piece++)
        {
            //System.out.println(myPieces.getPiece(piece));
            System.out.println(myPieces.getPiece(piece).getColour());
            board[myPieces.getPiece(piece).getX()][myPieces.getPiece(piece).getY()] = myPieces.getPiece(piece).getChar();
        }
    }
    
    @Override
    public void displayBoard(Pieces myPieces) //really doesn't need this parameter
    {
        System.out.println(" |ABCDEFGH");
        System.out.println("----------");
        
        //display board loops
        for (int row = 0; row < 8; row++) 
        {
            System.out.print(row + " ");
            for (int col = 0; col < 8; col++)
            {
                
                System.out.print(board[col][row]);
            }
            System.out.println();
        }
	}
    

    public static void main(String[] args) 
    {
        Board board = new Board();
        Pieces kuro = new Pieces(board, 0);
        Pieces shiro = new Pieces(board, 1);
        
        TextDisplay display = new TextDisplay();
        display.addPieces(kuro);
        display.addPieces(shiro);
        
        display.displayBoard(shiro);
    }
}
