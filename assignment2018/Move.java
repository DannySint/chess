package assignment2018;

import assignment2018.codeprovided.Piece;

public class Move 
{
	//instance variables
	private Piece piece;
	private int x;
	private int y;
	private int newX;
	private int newY;
	private boolean captured;
	
	public Move(Piece piece, int x, int y, int newX, int newY, boolean captured)
		{this.piece = piece; this.x = x; this.y = y; this.newX = newX; this.newY = newY; this.captured = captured;}

}
