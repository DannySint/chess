package assignment2018;

import assignment2018.codeprovided.Piece;

/**
 * Move class that stores data about a piece's move from one place to another with a capture flag
 * @author Danny
 */
public class Move 
{
    //instance variables
    private Piece piece;
    private int x;
    private int y;
    private int newX;
    private int newY;
    private boolean captured;
    
    /**
     * Move constructor to store the data about the piece's move 
     * @param piece contains the piece object
     * @param x contains the old x position
     * @param y contains the old y position
     * @param newX contains the (hopefully) new x position
     * @param newY contains the (hopefully) new y position 
     * @param captured contains the flag if the piece has taken another on its way
     */
    public Move(Piece piece, int x, int y, int newX, int newY, boolean captured)
    {
      this.piece = piece;
      this.x = x;
      this.y = y;
      this.newX = newX;
      this.newY = newY;
      this.captured = captured;
      // check board if new position is available
      // check with availableMove if current position to new position is possible
    }
    
    /**
     * From this method we are checking if the move exists within the piece's movepool and executing the move if so
     * If the move captures an enemy piece, there is special code for deleting that piece from the pieceset 
     * @return true if move exists
     * @return false if move does not exist within movepool
     */
    public boolean movePiece(Board board)
    {
        for (int i=0; i<piece.availableMoves().size(); i++)
        {
            //System.out.println("Pawn's X Moves: " + piece.availableMoves().get(i).getX() + " NewX: " + newX);
            //System.out.println("Pawn's Y Moves " + piece.availableMoves().get(i).getY() + " NewY: " + newY);
            
            if ((piece.availableMoves().get(i).getNewX() == newX) && (piece.availableMoves().get(i).getNewY() == newY))
            {
                //if (this.captured) //if the moved to piece is captured then it needs to be searched for and deleted
                if (piece.availableMoves().get(i).captured)
                {
                    //black search for piece
                    for (int j=0; j<board.getBlack().getNumPieces(); j++)
                    {
                        if ((board.getBlack().getPiece(j).getX() == this.newX) && (board.getBlack().getPiece(j).getY() == this.newY))
                        {
                            board.getBlack().delete(board.getBlack().getPiece(j));
                            //piece.setPosition(newX, newY);
                            return true;
                        }
                    }
                    
                    //white search for piece
                    for (int j=0; j<board.getWhite().getNumPieces(); j++)
                    {
                        if ((board.getWhite().getPiece(j).getX() == this.newX) && (board.getWhite().getPiece(j).getY() == this.newY))
                        {
                            board.getWhite().delete(board.getWhite().getPiece(j));
                            //piece.setPosition(newX, newY);
                            return true;
                        }
                    }
                }
                else
                {
                    //piece.setPosition(newX, newY);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean capturePiece(Board board) 
    {
        //black search for piece
        for (int i=0; i<board.getBlack().getNumPieces(); i++)
        {
            if ((board.getBlack().getPiece(i).getX() == this.newX) && (board.getBlack().getPiece(i).getY() == this.newY))
                {
                    board.getBlack().delete(board.getBlack().getPiece(i));
                    //piece.setPosition(newX, newY);
                    return true;
                }
        }
        
        //white search for piece
        for (int i=0; i<board.getWhite().getNumPieces(); i++)
        {
            if ((board.getWhite().getPiece(i).getX() == this.newX) && (board.getWhite().getPiece(i).getY() == this.newY))
                {
                    board.getWhite().delete(board.getWhite().getPiece(i));
                    //piece.setPosition(newX, newY);
                    return true;
                }
        }
        return false;
    }
    
    //accessor methods
    public int getX() {return x;}
    public int getY() {return y;}
    public int getNewX() {return newX;}
    public int getNewY() {return newY;}
    public boolean getCaptured() {return captured;}
    public int getCapturedValue(Board board)  {return board.getPiece(newX, newY).getValue();}
}
