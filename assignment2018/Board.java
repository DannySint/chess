package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

/**
 * Class to represent the current state of the board
 * @author Danny
 *
 */
public class Board 
{
    private Pieces white;
    private Pieces black;
    private Piece[][] board = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];

    /**
     * Constructor method to add both sets of pieces to the board
     */
    public Board() 
    {
        // create pieces
        white = new Pieces(this, PieceCode.WHITE);
        black = new Pieces(this, PieceCode.BLACK);
    }
    
    /**
     * Initial piece set up
     * @param x coordinate for where the piece is set to
     * @param y coordinate for where the piece is set to
     * @param thePiece the piece in question
     */
    public void setPosition(int x, int y, Piece thePiece) 
    {
        board[x][y] = thePiece;
    }

    /**
     * Method that checks if user supplied coordinates are outside of the board's
     * range
     * @param x is the passed x coordinate
     * @param y is the passed y coordinate
     * @return true if coordinates are out of range
     * @return false if coordinates are fine
     */
    public boolean outOfRange(int x, int y) 
    {
        if (x > 7 || x < 0) {
            return true;
        }
        if (y > 7 || y < 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to set the position of a piece for a piece's movement
     * If the occupying piece is a different colour from the moving piece the opposing piece is deleted  
     * @param x
     * @param y
     * @param thePiece
     * @return false if the both pieces are on the same side
     * @return true if the requested square is empty
     * @return true if the requested square's position is occupied by a member of the opposing team
     */
    public boolean insertPiece(int x, int y, Piece thePiece) 
    {
        if (this.getPiece(x, y) == null) //if board is empty
        {
            thePiece.setPosition(x, y);
            return true;
        }
        else if ((this.getPiece(x, y) != null) && (this.getPiece(x, y).getColourChar() == thePiece.getColourChar()))
        //if piece is same colour as occupied pieces
        {
            System.out.println("The piece you are trying to take is on your team.");
            return false;
        }
        else if ((this.getPiece(x, y) != null) && this.getPiece(x, y).getColourChar() != thePiece.getColourChar())
        {
            switch (this.getPiece(x, y).getColourChar())
            {
            case 'b' :
                black.delete(this.getPiece(x, y));
            break;
            case 'w' :
                white.delete(this.getPiece(x, y));
            break;
            }
            thePiece.setPosition(x, y);
            return true;
        }
        return false;
        
    }

    public void removePiece(int x, int y) 
    {}

    /**
     * Method to return what piece is at a particular location
     * @param x is the passed x coordinate
     * @param y is the passed y coordinate
     * @return the piece if exists among white or black
     * @return null if no piece exists at particular location
     */
    public Piece getPiece(int x, int y) {
        if (occupied(x, y)) {
            for (int i=0; i < white.getNumPieces(); i++) 
            {
                if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) 
                {
                    return white.getPiece(i);
                }
            }
            
            for (int i=0; i < black.getNumPieces(); i++)
            {
                if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) 
                {
                    return black.getPiece(i);
                }
            }
        }
        return null;
    }

    //getter methods
    //returns state of board
    public Board getBoard() {return this;} //useless but I'm too scared to take it out
    public Piece[][] returnBoard() {return board;}
    public Pieces getWhite() {return white;}
    public Pieces getBlack() {return black;}

    /**
     * Method to check if a space is occupied
     * 
     * @param x is passed x coordinate
     * @param y is passed y coordinate
     * @return true if a piece exists
     * @return false if no piece exists
     */
    public boolean occupied(int x, int y) 
    {
        for (int i=0; i < white.getNumPieces(); i++) 
        {
            if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) 
            {
                return true;
            }
        }
        for (int i=0; i < black.getNumPieces(); i++) 
        {
            if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) 
            {
                return true;
            }
        }
        return false;
    }
}
