package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

public class Queen extends PieceMovement
{
    
    public Queen(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.QUEEN, ix, iy, c, b);
    }
    
    // method implements abstract availableMoves method in Piece class
    public ArrayList<Move> availableMoves() {

        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        //set up movePool to return the list of available moves
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        //UP
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull((x), (y+i)));}
            else 
                {break;}
        }
        
        //UP and RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x+i, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull((x+i), (y+i)));}
            else 
                {break;}
        }
        
        //RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x+i, y) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull((x+i), (y)));}
            else 
                {break;}
        }
        
        //DOWN and RIGHT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x+i, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull(x+i, y-i));}
            else 
                {break;}
        }
        
        
        //DOWN
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull((x), (y-i)));}
            else 
                {break;}
        }
        
        //DOWN and LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x-i, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull(x-i, y-i));}
            else 
                {break;}
        }
        
        //LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x-i, y) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull((x-i), (y)));}
            else 
                {break;}
        }
        
        //UP and LEFT
        for (int i = 1; i < 7; i++)
        {
            if (moveFull(x-i, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {movePool.add(moveFull(x-i, y+i));}
            else 
                {break;}
        }
        
        return movePool;
    }

}
