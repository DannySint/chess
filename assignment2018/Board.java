package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class Board 
{

	private Piece[][] board = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];
	
	public Board() {}
	
	//setup board
	public void setup() {}
	
	public void setPosition(int i, int j, Piece thePiece) {}
	
	
	//method to check if a space is occupied 
	public boolean occupied() {return false;}
	
	public boolean outOfRange(int x, int i) 
	{
		if (x > 7 || x < 0)
			{
				if (i > 7 || i < 0)
				{return true;}
			}
		return false;
	}
	
	public void insertPiece() {}
	
	public void removePiece() {}
	
	//return piece at particular location
	public Piece getPiece(int x, int y) 
	{
		if (!occupied()) {return ?;}
		else {}
	}
	
	//returns state of board
	public Piece[][] returnBoard() {return board;}
	
	public static void main(String[] args) {System.out.println("");
	}
}
