package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.*;

public class Rook extends Piece {

    public Rook(int ix, int iy, int c, Board b) {
        super(PieceCode.ROOK, ix, iy, c, b);
    }

    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {
    	//return null;
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();
            
        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();
        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
        
        /**
         * Rook's UP Loop
         */
        for (int i=1; i<7; i++)
        {
            if (getBoard().outOfRange(x, y+i)) {break;}            
            
            if (!getBoard().occupied(x, y+i))
            {
                theMove = new Move(this, x, y, x, y + i, false);
                whiteMoves.add(theMove);
                blackMoves.add(theMove);
            }
            
            //if the square is occupied then test which colour is there
            if (getBoard().occupied(x, y+1)) 
            {
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, y+i).getColourChar() == 'w')) //white collides with white - so do not grant move
                {}
                if ((this.getColourChar() == 'w') && (getBoard().getPiece(x, y+i).getColourChar() == 'b')) //white takes black - grant move
                {theMove = new Move(this, x, y, x, (y + i), true);}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, y+i).getColourChar() == 'b')) //white collides with black - so do not grant move
                {}
                if ((this.getColourChar() == 'b') && (getBoard().getPiece(x, y+i).getColourChar() == 'w')) //black takes white - grant move
                {theMove = new Move(this, x, y, x, (y + i), true);}
                
            }
            
            if (getBoard().occupied(x, y+i)) {break;}
        }
        return null;
        
        /*    
            // first legal move is to go from x,y to x,y+1 if x,y+1 is unoccupied
            if (!getBoard().occupied(x, y + 1)) {
                theMove = new Move(this, x, y, x, y + 1, false);
                whiteMoves.add(theMove);
            }
    
            // second legal move is to go from x,y to x,y+2 if x,y+2 is unoccupied]
            // and pawn is on starting row 1
            if ((y == 1) && (!getBoard().occupied(x, y + 2))) {
                theMove = new Move(this, x, y, x, y + 2, false);
                whiteMoves.add(theMove);
            }
    
            // third legal move is to go from x,y to x+1,y+1 if x+1,y+1 is occupied
            // by a black piece, which is taken by setting the take flag to true
            if (diagonalMove(x + 1, y + 1)) {
                theMove = new Move(this, x, getY(), x + 1, y + 1, true);
                whiteMoves.add(theMove);
            }
    
            // fourth legal move is to go from x,y to x-1,y+1 if x-1,y+1 is occupied
            // by a black piece, which is taken by setting the take flag to true
            if (diagonalMove(x - 1, y + 1)) {
                theMove = new Move(this, x, y, x - 1, y + 1, true);
                whiteMoves.add(theMove);
            }
    
            if (whiteMoves.isEmpty())
                return null;
            return whiteMoves;
        }
        }
    
        // method to return list of legal moves for a white pawn
        private ArrayList<Move> whiteRook() {
        	return null;
    */
    }
	
}
