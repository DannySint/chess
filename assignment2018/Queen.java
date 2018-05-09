package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

/**
 * The Queen class that can move diagonally and straight in any direction so long as there is open space or any enemy.
 * Uses the PieceMovement's moveFull method that grows the movepool until there is an out of range or the space is occupied. 
 * @author Danny
 */

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
        ArrayList<Move> movepool = new ArrayList<Move>();
        
        //UP
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {movepool.add(moveFull((x), (y+i)));}
            else 
                {break;}
        }
        
        //UP and RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x+i), (y+i)));
                    if (getBoard().occupied(x+i, y+i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x+i), (y)));
                    if (getBoard().occupied(x+i, y))
                    {break;}
                }
            else 
                {break;}
        }
        
        //DOWN and RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x+i, y-i));
                    if (getBoard().occupied(x+i, y-i))
                    {break;}
                }
            else 
                {break;}
        }
        
        
        //DOWN
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x), (y-i)));
                    if (getBoard().occupied(x, y-i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //DOWN and LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y-i) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x-i, y-i));
                    if (getBoard().occupied(x-i, y-i))
                    {break;}
                }
            
            else 
                {break;}
        }
        
        //LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x-i), (y)));
                    if (getBoard().occupied(x-i, y))
                    {break;}
                }
            else 
                {break;}
        }
        
        //UP and LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y+i) != null) //if the queen has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x-i, y+i));
                    if (getBoard().occupied(x-i, y+i))
                    {break;}
                }
            else 
                {break;}
        }
        
        return movepool;
    }

}