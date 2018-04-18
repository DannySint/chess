package assignment2018;

import java.util.ArrayList;

import assignment2018.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class King extends Piece 
{

    public King(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.KING, ix, iy, c, b);
    }
    
    public ArrayList<Move> moveKing(int x, int y)
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
    
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current coordinates
        int x = this.getX();
        int y = this.getY();

        // set up theMove to refer to a Move object
        Move theMove = null;
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        //UP
        movePool.addAll(this.moveKing(x, (y+1)));
        
        //UP-RIGHT
        movePool.addAll(this.moveKing(x+1, y+1));
        
        //RIGHT
        movePool.addAll(this.moveKing(x+1, y));
        
        //RIGHT-DOWN
        movePool.addAll(this.moveKing(x+1, y-1));
        
        //DOWN
        movePool.addAll(this.moveKing(x, y-1));
        
        //DOWN-LEFT
        movePool.addAll(this.moveKing(x-1, y-1));
        
        //LEFT
        movePool.addAll(this.moveKing(x-1, y));
        
        //LEFT-UP
        movePool.addAll(this.moveKing(x-1, y+1));
        return movePool;
    }

}
