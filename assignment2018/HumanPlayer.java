package assignment2018;

import java.util.Scanner;

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
        
        return false;
    }
    
    public int[] requestMove()
    {
        from = "h2";
        to = "h2";
        scanner = new Scanner(System.in);
        do {
            do {
                do {
                    from = scanner.next(); 
                    to = scanner.next();
                    convertCoords();
                    for (int i : jump) {System.out.println(i);}
                    //- request moves loop ("to" , "from")
                    
                    
                } while (convertCoords() == false);
            } while (outOfRange());
        } while (pieceBelongsToPlayer() == false);
        System.out.println("From: (" + jump[0] + ", " + jump[1] + ")");        
        
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
        return false;
    }
    
    public boolean outOfRange()
    {
        for (int i=0; i<jump.length;i++)
        {
            if ((jump[i] < 0) || jump[i] > 7) 
                {return true;}
        }
        return false;
    }
    
    public static void main(String[] args) 
    {
        Board board = new Board();
        HumanPlayer avenger = null;
        HumanPlayer ruler = new HumanPlayer("ruler", new Pieces(board, 0), board, avenger);
        avenger = new HumanPlayer("avenger", new Pieces(board, 1), board, (Player)ruler);
        int[] jump = ruler.requestMove();
        Move move;
        Chess.warp(jump[0], jump[1], jump[2], jump[3], board);
    }
}
