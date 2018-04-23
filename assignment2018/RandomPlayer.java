package assignment2018;

import java.util.ArrayList;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class RandomPlayer extends Player
{
    private ArrayList<Move> movepool;
    private Move move;
    private int randomNumber;
    public RandomPlayer(String name, Pieces pieces, Board board, Player opponent) 
    {
        super(name, pieces, board, opponent);
    }
    public int[] requestMove()
    {
        move = null;
        movepool = new ArrayList<Move>();
        int jump[] = new int[4];
        
        for (int i=0; i< this.getPieces().getNumPieces(); i++)
        {
            //store them in an arraylist
            movepool.addAll(this.getPieces().getPiece(i).availableMoves());
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
    
    @Override
    public boolean makeMove() 
    {
        int[] move = requestMove();
        Piece piece = getBoard().getPiece(move[0], move[1]);
        
        for(Move m : piece.availableMoves()) 
        {
            if(move[2] == m.getNewX() && move[3] == m.getNewY()) 
            {
                System.out.println(getBoard().getPiece(move[0], move[1]));
                System.out.println("Random Move: " + "(" + move[0] + ", " + move[1] + ") to (" + move[2] + ", " + move[3] + ")");
                return getBoard().setPosition(move[2], move[3], piece);
            }
        }
        System.out.println("Your designated move was illegal.");
        return false;
    }
}
