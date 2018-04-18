package assignment2018;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

public class HumanPlayer extends Player
{
    
    
    public HumanPlayer(String name, Pieces pieces, Board board, Player opponent)
        {super(name, pieces, board, opponent);}

    @Override
    public boolean makeMove() 
    {
        if (moveIsMValid() ) 
            {return true;}
        else
            {return false;}
    }
    
    private boolean moveIsMValid() {return true;}

    public static void main(String[] args) {}
}
