package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

public class Rook extends PieceMovement {

    public Rook(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.ROOK, ix, iy, c, b);
    }
    
    // method implements abstract availableMoves method in Piece class
    @Override
    public ArrayList<Move> availableMoves() {

        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        //set up movePool to return the list of available moves
        ArrayList<Move> movepool = new ArrayList<Move>();
        
        //UP
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x, y+i) != null) //if the rook has encountered resistance, stop adding moves 
                {movepool.add(moveFull((x), (y+i)));}
            else 
                {break;}
        }
        
        //RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x+i, y) != null) //if the rook has encountered resistance, stop adding moves 
                {movepool.add(moveFull((x+i), (y)));}
            else 
                {break;}
        }
        
        //DOWN
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x, y-i) != null) //if the rook has encountered resistance, stop adding moves 
                {movepool.add(moveFull((x), (y-i)));}
            else 
                {break;}
        }
        
        //LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x-i, y) != null) //if the rook has encountered resistance, stop adding moves 
                {movepool.add(moveFull((x-i), (y)));}
            else 
                {break;}
        }
        
        return movepool;
    }
	
}
