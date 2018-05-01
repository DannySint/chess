package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

/**
 * Class representing Rooks
 * Rook extends from PieceMovement's methods that extends from Piece
 * The rook can move UP, RIGHT, DOWN, LEFT so there are 4 loops that break upon contact with another player 
 * @author Danny
 *
 */
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
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x, y+i) != null) //if the rook has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x), (y+i)));
                    if (getBoard().occupied(x, y+i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //RIGHT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x+i, y) != null) //if the rook has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x+i), (y)));
                    if (getBoard().occupied(x+i, y))
                    {break;}
                }
            else 
                {break;}
        }
        
        //DOWN
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x, y-i) != null) //if the rook has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x), (y-i)));
                    if (getBoard().occupied(x, y-i))
                    {break;}
                }
            else 
                {break;}
        }
        
        //LEFT
        for (int i=1; i < 7; i++)
        {
            if (moveFull(x-i, y) != null) //if the rook has encountered resistance, stop adding moves 
                {
                    movepool.add(moveFull((x-i), (y)));
                    if (getBoard().occupied(x-i, y))
                    {break;}
                }
            else 
                {break;}
        }
        
        return movepool;
    }
	
}
