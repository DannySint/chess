package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class RandomPlayer extends Player
{
    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent) 
    {
        super(name, pieces, board, opponent);
    }
    public int[] requestMove()
    {
        Move move = null;
        ArrayList<Move> movepool = null;
        int jump[] = new int[4];
        for (int i=0; i< this.getPieces().getNumPieces(); i++)
        {
            //store them in an arraylist
            movepool = this.getPieces().getPiece(i).availableMoves();
        }
        
        //error here
        move = (movepool.get((int)Math.random() * movepool.size()));
        jump[0] = move.getX();
        jump[1] = move.getY();
        jump[2] = move.getNewX();
        jump[3] = move.getNewY();
        return jump;
    }
    
    @Override
    public boolean makeMove() {
        
        return false;
    }
}
