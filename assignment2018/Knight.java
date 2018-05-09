package assignment2018;

import java.util.ArrayList;
import assignment2018.codeprovided.PieceCode;

/**
 * The Knight class that can move 2 spaces vertical/horizontal and then 1 space horizontal/vertical in any direction.
 * Uses the PieceMovement's moveSingle method that only adds the move to the movepool if it is valid. 
 * @author Danny
 */
public class Knight extends PieceMovement
{
    
    public Knight(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.KNIGHT, ix, iy, c, b);
    }
    
    /**
     * All the Knight's available moves are added to the movepool.
     * @return movepool
     */
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current coordinates
        int x = this.getX();
        int y = this.getY();

        // set up movePool to return the list of available moves
        ArrayList<Move> movepool = new ArrayList<Move>();
        
        //Right 2
            //Up 1
        movepool.addAll(this.moveSingle(x+2, y+1));
            //Down 1
        movepool.addAll(this.moveSingle(x+2, y-1));
        
        //Left 2
            //Up 1
        movepool.addAll(this.moveSingle(x-2, y+1));
            //Down 1
        movepool.addAll(this.moveSingle(x-2, y-1));
        
        
        //Up 2
            //Right 1
        movepool.addAll(this.moveSingle(x+1, y+2));
            //Left 1
        movepool.addAll(this.moveSingle(x-1, y+2));
        //Down 2
            //Left 1
        
        //Down 2
            //Right 1
        movepool.addAll(this.moveSingle(x+1, y-2));
            //Left 1
        movepool.addAll(this.moveSingle(x-1, y-2));
        
        return movepool;
    }

}