package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.PieceCode;

public class Knight extends PieceMovement
{

    public Knight(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.KNIGHT, ix, iy, c, b);
    }
    
    @Override
    public ArrayList<Move> availableMoves() 
    {
        // obtain current co-ordinates
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