package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;

public class Rook extends Piece {

    public Rook(int ix, int iy, int c, Board b) {
        super(PieceCode.ROOK, ix, iy, c, b);
    }

    public ArrayList<Move> moveRook(int x, int y)
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
    
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {

        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // set up theMove to refer to a Move object
        Move theMove = null;
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        /**
         * Rook's UP Loop
         */
        for (int i=1; i<7; i++)
        {
            
            if (getBoard().outOfRange(x, y+i)) 
                {break;}            
            
            if (!getBoard().occupied(x, y+i))
            {
                theMove = new Move(this, x, y, x, (y+i), false);
                movePool.add(theMove);
            }
            
            //if the square is occupied then test which colour is there
            if (getBoard().occupied(x, (y+i))) 
            {
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, (y+i)).getColourChar() == 'w')) //white collides with white - so do not grant move
                {System.out.println("WW");}
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, (y+i)).getColourChar() == 'b')) //white takes black - grant move
                {
                    theMove = new Move(this, x, y, x, (y+i), true);
                    movePool.add(theMove);
                }
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, (y+i)).getColourChar() == 'b')) //black collides with black - so do not grant move
                {System.out.println("BB");}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, (y+i)).getColourChar() == 'w')) //black takes white - grant move
                {
                    theMove = new Move(this, x, y, x, (y + i), true);
                    movePool.add(theMove);
                }
                
            }
            
            if (getBoard().occupied(x, y+i)) {break;}
        }
        
        /**
         * Rook's DOWN Loop
         */
        for (int i=1; i<7; i++)
        {
            
            if (getBoard().outOfRange(x, (y-i))) 
                {break;}
            //System.out.println("X: " + x + " y: " + y + " i: " + i);
            //System.out.println("X: " + x + " Y: " + (y-i));
            if (!getBoard().occupied(x, (y-i))) //if square is not occupied
            {
                
                theMove = new Move(this, x, y, x, (y-i), false);
                movePool.add(theMove);
            }
            
            //if the square is occupied then test which colour is there
            if (getBoard().occupied(x, (y-i))) 
            {
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, (y-i)).getColourChar() == 'w')) //white collides with white - so do not grant move
                {}
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, (y-i)).getColourChar() == 'b')) //white takes black - grant move
                {
                    theMove = new Move(this, x, y, x, (y-i), true);
                    movePool.add(theMove);
                }
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, (y-i)).getColourChar() == 'b')) //black collides with black - so do not grant move
                {}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, (y-i)).getColourChar() == 'w')) //black takes white - grant move
                {
                    theMove = new Move(this, x, y, x, (y-i), true);
                    movePool.add(theMove);
                }
            }
            
            if (getBoard().occupied(x, (y-i))) 
                {break;}
        }
        
        /**
         * Rook's LEFT Loop
         */
        for (int i=1; i<7; i++)
        {
            
            if (getBoard().outOfRange((x-i), y)) 
                {break;}
            //System.out.println("X: " + x + " y: " + y + " i: " + i);
            //System.out.println("X: " + x + " Y: " + (y-i));
            if (!getBoard().occupied((x-i), y))
            {
                
                theMove = new Move(this, x, y, (x-i), y, false);
                movePool.add(theMove);
            }
            
            //if the square is occupied then test which colour is there
            if (getBoard().occupied((x-i), y)) 
            {
                if ((this.getColourChar() == 'w') && (getBoard().getPiece((x-i), y).getColourChar() == 'w')) //white collides with white - so do not grant move
                {}
                if ((this.getColourChar() == 'w') && (getBoard().getPiece((x-i), y).getColourChar() == 'b')) //white takes black - grant move
                {
                    theMove = new Move(this, x, y, (x-1), y, true);
                    movePool.add(theMove);
                }
                if ((this.getColourChar() == 'b') && (getBoard().getPiece((x-i), y).getColourChar() == 'b')) //black collides with black - so do not grant move
                {}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece((x-i), y).getColourChar() == 'w')) //black takes white - grant move
                {
                    theMove = new Move(this, x, y, (x-i), (y), true);
                    movePool.add(theMove);
                }
                
            }
            
            if (getBoard().occupied((x-i), y)) 
                {break;}
        }
        
        /**
         * Rook's RIGHT Loop
         */
        for (int i=1; i<7; i++)
        {
            
            if (getBoard().outOfRange((x+i), y)) 
                {break;}
            //System.out.println("X: " + x + " y: " + y + " i: " + i);
            //System.out.println("X: " + x + " Y: " + (y-i));
            if (!getBoard().occupied((x+i), y))
            {
                
                theMove = new Move(this, x, y, (x+i), y, false);
                movePool.add(theMove);
            }
            
            //if the square is occupied then test which colour is there
            if (getBoard().occupied((x+i), y)) 
            {
                if ((this.getColourChar() == 'w') && (getBoard().getPiece((x+i), y).getColourChar() == 'w')) //white collides with white - so do not grant move
                    {}
                if ((this.getColourChar() == 'w') && (getBoard().getPiece((x+i), y).getColourChar() == 'b')) //white takes black - grant move
                {
                    theMove = new Move(this, x, y, (x + 1), y, true);
                    movePool.add(theMove);
                }
                if ((this.getColourChar() == 'b') && (getBoard().getPiece((x+i), y).getColourChar() == 'b')) //black collides with black - so do not grant move
                    {}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece((x+i), y).getColourChar() == 'w')) //black takes white - grant move
                {
                    theMove = new Move(this, x, y, (x+i), (y), true);
                    movePool.add(theMove);
                }
                
            }
            
            if (getBoard().occupied((x+i), y)) 
                {break;}
        }
        
        return movePool;
    }
	
}
