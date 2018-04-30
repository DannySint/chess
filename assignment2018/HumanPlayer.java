package assignment2018;

import java.util.Scanner;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class HumanPlayer extends Player
{
    
    private String from;
    private String to;
    private int[] jump;
    private Scanner scanner;
    public HumanPlayer(String name, Pieces pieces, Board board, Player opponent)
    {
        super(name, pieces, board, opponent);
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
                return getBoard().insertPiece(move[2], move[3], piece);
            }
        }
        System.out.println("Your designated move was illegal.");
        return false;
    }
    
    public int[] requestMove()
    {
        from = "h2";
        to = "h2";
        
        do {
            from = "s";
            to = "";
            scanner = new Scanner(System.in);
            System.out.println(this.toString() + ", please enter a move: ");
            from = scanner.next().toUpperCase(); 
            to = scanner.next().toUpperCase();
            scanner = null;
            convertCoords();
            
        } while ((convertCoords() == false) || (outOfRange()) || (pieceBelongsToPlayer() == false) );
        //System.out.println("From: (" + jump[0] + ", " + jump[1] + ")");        
        
        return jump;
    }
    
    public boolean convertCoords() 
    {
        if ((from.length() == 2) && (!to.isEmpty()) && (to.length()) == 2)
        {
            int fromX = from.charAt(0) - 65;
            int fromY = from.charAt(1) - 48;
            int toX = to.charAt(0) - 65;
            int toY = to.charAt(1) - 48;
            int[] jump = {fromX, fromY, toX, toY};
            this.jump = jump;
            return true;
        }
        return false;
    }
    
    public boolean pieceBelongsToPlayer()
    {
        for (int i=0; i<this.getPieces().getNumPieces(); i++)
        {
            if ((this.getPieces().getPiece(i).getX() == jump[0]) && (this.getPieces().getPiece(i).getY() == jump[1]))
            {return true;}
        }
        System.out.println("The selected piece doesn't belong to you or doesn't contain anything.");
        return false;
    }
    
    public boolean outOfRange()
    {
        for (int i=0; i<jump.length;i++)
        {
            if ((jump[i] < 0) || jump[i] > 7) 
                {
                    System.out.println("Your designated move was out of range of the board.");
                    return true;
                }
        }
        
        return false;
    }
    
    /*public static void main(String[] args) 
    {
        Chess chess = new Chess();
        Board board = new Board();
        HumanPlayer avenger = null;
        HumanPlayer ruler = new HumanPlayer("ruler", new Pieces(board, 0), board, avenger);
        avenger = new HumanPlayer("avenger", new Pieces(board, 1), board, (Player)ruler);
        int[] jump = ruler.requestMove();
        Move move;
        chess.warp(jump[0], jump[1], jump[2], jump[3]);
    }*/
}
