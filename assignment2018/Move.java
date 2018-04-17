package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

public class Move 
{
    //instance variables
    private Piece piece;
    private int x;
    private int y;
    private int newX;
    private int newY;
    private boolean captured;
    
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
    public boolean testMove(Board board) 
    {
        boolean legal = false;
        if (this.captured) 
        {
            legal = capturePiece(board);
        } 
        else 
        {
            legal = movePiece();
        }
        return legal;
    }
    //from here, we need to check if the move exists within the piece's movepool and then execute it if it does
    public boolean movePiece()
    {
        for (int i=0; i<piece.availableMoves().size(); i++)
        {
            //System.out.println("Pawn's X Moves: " + piece.availableMoves().get(i).getX() + " NewX: " + newX);
            //System.out.println("Pawn's Y Moves " + piece.availableMoves().get(i).getY() + " NewY: " + newY);
            
            if ((piece.availableMoves().get(i).getNewX() == newX) && (piece.availableMoves().get(i).getNewY() == newY))
            {
                piece.setPosition(newX, newY);
                return true;
            }
            System.out.println();
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
                    piece.setPosition(newX, newY);
                    return true;
                }
        }
        
        //white search for piece
        for (int i=0; i<board.getWhite().getNumPieces(); i++)
        {
            if ((board.getWhite().getPiece(i).getX() == this.newX) && (board.getWhite().getPiece(i).getY() == this.newY))
                {
                    board.getWhite().delete(board.getWhite().getPiece(i));
                    piece.setPosition(newX, newY);
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
}
