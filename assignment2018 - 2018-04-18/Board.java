package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

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
	    //create pieces
        white = new Pieces(this, 0);
        black = new Pieces(this, 1);
	}
	
	/**
	 * Method to set the position of a piece
	 * @param x 
	 * @param y
	 * @param thePiece
	 */
	public void setPosition(int x, int y, Piece thePiece) 
	{
	    thePiece.setPosition(x, y);
	}
	
	/**
	 * Method that checks if user supplied coordinates are outside of the board's range
	 * @param x is the passed x coordinate
	 * @param y is the passed y coordinate
	 * @return true if coordinates are out of range
	 * @return false if coordinates are fine
	 */
	public boolean outOfRange(int x, int y) 
	{
		if (x > 7 || x < 0) {return true;} //if ((x>7 || x<0) && (y>7 || y<0)) {return true;} else {return false;}
		if (y > 7 || y < 0) {return true;}
		return false;
	}
	
	public void insertPiece() {}
	
	public void removePiece() {}
	
	/**
	 * Method to return what piece is at a particular location
	 * @param x is the passed x coordinate
	 * @param y is the passed y coordinate
	 * @return the piece if exists among white or black
	 * @return null if no piece exists at particular location
	 */
	public Piece getPiece(int x, int y) 
	{
		if (occupied(x,y)) 
		{
		    for (int i = 0; i < white.getNumPieces(); i++)
	        {
	            if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) {return white.getPiece(i);}
	            if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) {return black.getPiece(i);}
	        }
		}
		return null;
	}
	
	//returns state of board
    public Board getBoard() {return this;}
	public Piece[][] returnBoard() {return board;}
	public Pieces getWhite() {return white;}
	public Pieces getBlack() {return black;}
	
    /**
     * Method to check if a space is occupied
     * @param x is passed x coordinate
     * @param y is passed y coordinate
     * @return true if a piece exists
     * @return false if no piece exists
     */
	public boolean occupied(int x, int y) 
	{
	    for (int i = 0; i < white.getNumPieces(); i++)
	    {
	        if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) {return true;}
	        if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) {return true;}
	    }
	    return false;	    
	}
	
}
