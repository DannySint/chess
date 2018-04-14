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
    	return null;
    	/*
        if (getColour() == PieceCode.WHITE)
            return whiteRook();
        else
            return blackRook();
        */
    }

    // method to return list of legal moves for a white pawn
    private ArrayList<Move> whiteRook() {
    	return null;
    	/*
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // return null if the pawn is at the edge of the board, or if the
        // next move takes it out of range
        if ((y == 7) || (getBoard().outOfRange(x, y + 1)))
            return null;

        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        //UP Loop for Rooks
        for (int i = 0; i< (PieceCode.XSIZE - this.getX()); i++) 
        {
        	if (!getBoard().occupied(x + i, y))
        	{
        		theMove = new Move(this, x, y, (x + i), y, false);
        		whiteMoves.addAll(theMove);
        	}
        }
        
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

    // method to return Vector of legal moves for a black pawn
    private ArrayList<Move> blackPawn() {
        int x = this.getX();
        int y = this.getY();

        // return null if the pawn is at the edge of the board, or if the
        // next move takes it out of range
        if ((y == 0) || (getBoard().outOfRange(x, y - 1)))
            return null;

        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        // first legal move is to go from x,y to x,y+1 if x,y+1 is unoccupied
        if (!getBoard().occupied(x, y - 1)) {
            theMove = new Move(this, x, y, x, y - 1, false);
            blackMoves.add(theMove);
        }

        // second legal move is to go from x,y to x,y+2 if x,y+2 is unoccupied
        // and pawn is on starting row 6
        if ((y == 6) && (!getBoard().occupied(x, y - 2))) {
            theMove = new Move(this, x, y, x, y - 2, false);
            blackMoves.add(theMove);
        }

        // third legal move is to go from x,y to x+1,y+1 if x+1,y+1 is occupied
        // by a white piece, which is taken by setting the take flag to true
        if (diagonalMove(x + 1, y - 1)) {
            theMove = new Move(this, x, y, x + 1, y - 1, true);
            blackMoves.add(theMove);
        }

        // fourth legal move is to go from x,y to x-1,y+1 if x-1,y+1 is occupied
        // by a white piece, which is taken by setting the take flag to true
        if (diagonalMove(x - 1, y - 1)) {
            theMove = new Move(this, x, y, x - 1, y - 1, true);
            blackMoves.add(theMove);
        }

        if (blackMoves.isEmpty())
            return null;
        return blackMoves;
        */
    }
	
}
