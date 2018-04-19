package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Piece;

public abstract class PieceMovement extends Piece
{
    public PieceMovement(int i, int ix, int iy, int c, Board b) 
    {
        super(i, ix, iy, c, b);
    }
    
    /**
     * Method all pieces have access to that returns whether a move is valid. 
     * The difference between moveFull and moveSingle is moveFull is run with a loop whereas moveSingle is only run once.   
     * @param x checking if the x value is a valid move
     * @param y checking if the y value is a valid move 
     * @return Move object that is valid for the piece's available moveset
     */
    public Move moveFull(int x, int y)
    {
        
        Move theMove = null;
        //ArrayList<Move> movePool = new ArrayList<Move>();
        
        //check out of bounds
        
        if (!getBoard().outOfRange(x, y)) //not out of range
        {
            if (!getBoard().occupied(x,y)) 
            {
                theMove = new Move(this, this.getX(), this.getY(), x, y, false);
                return theMove;
                //movePool.add(theMove);
                
            }
            else //check collision
            {
                switch (this.getColourChar())
                {
                case 'w' :
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'w') 
                    {}
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'b') 
                    {
                        theMove = new Move(this, this.getX(), this.getY(), (x), (y), true);
                        return theMove;
                        //movePool.add(theMove);
                    }
                    break;
                    
                case 'b' :
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'w') 
                    {
                        theMove = new Move(this, this.getX(), this.getY(), (x), (y), true);
                        return theMove;
                        //movePool.add(theMove);
                    }
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'b') 
                    {}
                    break;
                }
            }
        }
        return null;
    }
    
    /**
     * Method all pieces have access to that returns whether a move is valid.
     * The difference between moveFull and moveSingle is moveFull is run with a loop whereas moveSingle is only run once.
     * @param x checking if the x value is a valid move
     * @param y checking if the y value is a valid move 
     * @return ArrayList<Move> collection that contains the list of moves the piece can do. REALLY should be combined.
     */
    public ArrayList<Move> moveSingle(int x, int y)
    {
        
        Move theMove = null;
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        //check out of bounds
        
        if (!getBoard().outOfRange(x, y)) //not out of range
        {
            if (!getBoard().occupied(x,y))
            {
                theMove = new Move(this, this.getX(), this.getY(), x, y, false);
                movePool.add(theMove);
                
            }
            else //check collision
            {
                switch (this.getColourChar())
                {
                case 'w' :
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'w') 
                    {}
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'b') 
                    {
                        theMove = new Move(this, this.getX(), this.getY(), (x), (y), true);
                        movePool.add(theMove);
                    }
                    break;
                    
                case 'b' :
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'w') 
                    {
                        theMove = new Move(this, this.getX(), this.getY(), (x), (y), true);
                        movePool.add(theMove);
                    }
                    if (this.getBoard().getPiece(x, (y)).getColourChar() == 'b') 
                    {}
                    break;
                }
            }
        }
        return movePool;
    }
}
