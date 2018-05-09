package assignment2018;

import java.util.ArrayList;
import java.lang.String;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

/**
 * Class for a Player that requests random moves based on its piece's movepool
 * @author Danny
 */

public class RandomPlayer extends Player
{
    private ArrayList<Move> movepool;
    private Move move;

    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent) 
    {
        super(name, pieces, board, opponent);
    }
    
    @Override
    public boolean makeMove() 
    {
        int[] move = requestMove();
        System.out.println("Random Move: " + "(" + move[0] + ", " + move[1] + ") to (" + move[2] + ", " + move[3] + ")");
        Piece piece = getBoard().getPiece(move[0], move[1]);
        
        for(Move m : piece.availableMoves()) 
        {
            if(move[2] == m.getNewX() && move[3] == m.getNewY()) 
            {
                System.out.println(getBoard().getPiece(move[0], move[1]));
                return getBoard().insertPiece(move[2], move[3], piece);
            }
        }
        System.out.println("Your designated move was illegal.");
        return false;
    }
    
    public int[] requestMove()
    {
        move = null;
        movepool = new ArrayList<Move>();
        int jump[] = new int[4];
        
        for (int i=0; i< this.getPieces().getNumPieces(); i++)
        {
            //store the available moves in an arraylist
            if (this.getPieces().getPiece(i).availableMoves() != null)
            {
                movepool.addAll(this.getPieces().getPiece(i).availableMoves());
            }
        }
        return returnRandomCoords(jump);
    }
    
    public int[] returnRandomCoords(int[] jump)
    {
        //error here
        int randomNumber = (int)(Math.random() * this.movepool.size());
        move = (this.movepool.get(randomNumber));
        jump[0] = move.getX();
        jump[1] = move.getY();
        jump[2] = move.getNewX();
        jump[3] = move.getNewY();
        return jump;
    }
    
    
}
