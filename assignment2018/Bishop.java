package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

/**
 * The Bishop class that can move diagonally in any direction so long as there is open space or any enemy.
 * Uses the PieceMovement's moveFull method that grows the movepool until there is an out of range or the space is occupied. 
 * @author Danny
 */
public class Bishop extends PieceMovement
{

    public Bishop(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }
    
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current coordinates
        int x = this.getX();
        int y = this.getY();

        //set up movePool to return the list of available moves
        ArrayList<Move> movepool = new ArrayList<Move>();
        
        //UP and RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y+i) != null) //if the bishop has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x+i), (y+i)));
                    if (getBoard().occupied(x+i, y+i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //UP and LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y+i) != null) //if the bishop has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x-i, y+i));
                    if (getBoard().occupied(x-i, y+i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //DOWN and LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y-i) != null) //if the bishop has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x-i, y-i));
                    if (getBoard().occupied(x-i, y-i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //DOWN and RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y-i) != null) //if the bishop has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull(x+i, y-i));
                    if (getBoard().occupied(x+i, y-i))
                    {break;}
                }
            else 
                {break;}
        }
        
        return movepool;
    }

}