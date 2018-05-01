package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class AggressivePlayer extends RandomPlayer 
{
    private ArrayList<Move> movepool;
    private Move move;
    private int randomNumber;
    
    public AggressivePlayer(String name, Pieces pieces, Board board, Player opponent) 
    {
        super(name, pieces, board, opponent);
    }
    
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
        //high piece
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
