package assignment2018;
import assignment2018.codeprovided.*;

public class TextDisplay implements Display
{
    //instance variables
    private char[][] board;
    
    /**
     * Creates the board with 8 x 8.
     * Initialises each square with a "."
     */
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
    /**
     * Run a loop to add all pieces in myPieces to the array
     * @param myPieces
     */
    public void addPieces(Pieces myPieces)
    {
        for (int piece = 0; piece < myPieces.getNumPieces(); piece++)
        {
            //System.out.println(myPieces.getPiece(piece));
            board[myPieces.getPiece(piece).getX()][myPieces.getPiece(piece).getY()] = myPieces.getPiece(piece).getChar();
        }
    }
    
    /**
     * Displays the board coordinates and then displays each square of the board.
     */
    @Override
    public void displayBoard(Pieces myPieces) //really doesn't need this parameter
    {
        System.out.println(" |ABCDEFGH");
        System.out.println(" |01234567");
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
        System.out.println();
        clearBoard();
    }
    
    public void clearBoard()
    {
        for (int row = 0; row < 8; row++) 
        {
            for (int col = 0; col < 8; col++)
            {
                board[col][row] = '.';
            }
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
