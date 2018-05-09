package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import java.lang.String; 

/**
 * Class for an AggressivePlayer requests moves that would take the higher value piece
 * of its opponent. If such moves are unavailable the player reverts to using random available moves.
 * @author Danny
 */

public class AggressivePlayer extends RandomPlayer 
{
    private ArrayList<Move> movepool;
    private Move move;
    
    public AggressivePlayer(String name, Pieces pieces, Board board, Player opponent) 
    {
        super(name, pieces, board, opponent);
    }
    
    /**
     * Method to get a move. 
     * This class activates the returnCoords and returns the move that captures the higher value piece.
     */
    @Override
    public int[] requestMove()
    {
        this.move = null;
        this.movepool = new ArrayList<Move>();
        int jump[] = new int[4];
        
        for (int i=0; i< this.getPieces().getNumPieces(); i++)
        {
            //store them in an arraylist
            if (this.getPieces().getPiece(i).availableMoves() != null)
            {
                movepool.addAll(this.getPieces().getPiece(i).availableMoves());
            }

        }
        return returnCoords(jump);
    }
    
    public int[] returnCoords(int[] jump)
    {
        int currentMax = 0;
        //take highest value piece
        for (int i = 0; i < this.movepool.size(); i++)
        {
            if (this.movepool.get(i).getCaptured() == true)
            {
                if (this.movepool.get(i).getCapturedValue(getBoard()) >  currentMax)
                {
                    currentMax = this.movepool.get(i).getCapturedValue(getBoard());
                    this.move = this.movepool.get(i);
                }
            }
        }
        
        //random
        if (currentMax == 0)
        {
            int randomNumber = (int)(Math.random() * this.movepool.size());
            this.move = (this.movepool.get(randomNumber));
        }
        jump[0] = this.move.getX();
        jump[1] = this.move.getY();
        jump[2] = this.move.getNewX();
        jump[3] = this.move.getNewY();
        return jump;
    }

}
