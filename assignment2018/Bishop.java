package assignment2018;

import java.util.ArrayList;

import assignment2018.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class Bishop extends Piece 
{

    public Bishop(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }

    public Move moveBishop(int x, int y)
    {
        
        Move theMove = null;
        ArrayList<Move> movePool = new ArrayList<Move>();
        
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
    
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // set up theMove to refer to a Move object
        Move theMove = null;
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        //UP and RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveBishop(x+i, y+i) != null) //if the bishop has encountered resistance, stop adding moves 
                {movePool.add(moveBishop((x+i), (y+i)));}
            else 
                {break;}
        }
        
        //UP and LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveBishop(x-i, y+i) != null) //if the bishop has encountered resistance, stop adding moves 
                {movePool.add(moveBishop(x-i, y+i));}
            else 
                {break;}
        }
        
        //DOWN and LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveBishop(x-i, y-i) != null) //if the bishop has encountered resistance, stop adding moves 
                {movePool.add(moveBishop(x-i, y-i));}
            else 
                {break;}
        }
        
        //DOWN and RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveBishop(x+i, y-i) != null) //if the bishop has encountered resistance, stop adding moves 
                {movePool.add(moveBishop(x+i, y-i));}
            else 
                {break;}
        }
        
        return movePool;
    }

}