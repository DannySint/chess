package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

public class Board 
{
    private Pieces white;
    private Pieces black;
	private Piece[][] board = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];
	
	public Board() 
	{
	    //create pieces
        white = new Pieces(this, 0);
        black = new Pieces(this, 1);
	}
	
	//setup board
	public void setup() {}
	
	public void setPosition(int x, int y, Piece thePiece) {}
		
	public boolean outOfRange(int x, int y) 
	{
		if (x > 7 || x < 0)
			{
				if (y > 7 || y < 0)
				{return true;}
			}
		return false;
	}
	
	public void insertPiece() {}
	
	public void removePiece() {}
	
	//return piece at particular location
	public Piece getPiece(int x, int y) 
	{
		return null;
		//if (!occupied()) {return ?;} else {}
	}
	
	//returns state of board
    public Board getBoard() {return this;}
	public Piece[][] returnBoard() {return board;}
	public Pieces getWhite() {return white;}
	public Pieces getBlack() {return black;}
	
	
	
    //method to check if a space is occupied
	public boolean occupied(int x, int y) {return false;}
	
	public static void main(String[] args) {System.out.println("");}
}
