package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

/**
 * The Knight Piece class inheriting PieceMovement 
 * @author Danny
 */
public class King extends PieceMovement
{

    public King(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.KING, ix, iy, c, b);
    }
    
    /**
     * All the King's available moves are added to the movepool.
     * @return movepool
     */
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current coordinates
        int x = this.getX();
        int y = this.getY();

        //set up movePool to return the list of available moves
        ArrayList<Move> movePool = new ArrayList<Move>();
        
        //UP
        movePool.addAll(this.moveSingle(x, (y+1)));
        
        //UP-RIGHT
        movePool.addAll(this.moveSingle(x+1, y+1));
        
        //RIGHT
        movePool.addAll(this.moveSingle(x+1, y));
        
        //RIGHT-DOWN
        movePool.addAll(this.moveSingle(x+1, y-1));
        
        //DOWN
        movePool.addAll(this.moveSingle(x, y-1));
        
        //DOWN-LEFT
        movePool.addAll(this.moveSingle(x-1, y-1));
        
        //LEFT
        movePool.addAll(this.moveSingle(x-1, y));
        
        //LEFT-UP
        movePool.addAll(this.moveSingle(x-1, y+1));
        
        return movePool;
    }

}
