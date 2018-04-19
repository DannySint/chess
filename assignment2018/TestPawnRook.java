package assignment2018;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class TestPawnRook 
{
    Chess chess = new Chess();
    int x, y, newX, newY = 0;
    Board board;
    Move move;
    
    @Before
    public void setup()
    {
        Chess.init();
        
    }
    
    @Test
    public void testPawns() 
    {
        int turnNumber = 1;
        do
        {
            System.out.println(turnNumber);
            switch (turnNumber)
            {
                
                case 1: 
                    //Black Pawn H6 to H4
                    x=7;y=6;
                    newX=7; newY=4;
                break;
                
                case 2:
                    //Black Rook H7 to H5
                    x=7; y=7;
                    newX=7; newY=5;
                break;
                
                case 3: 
                    //Black Rook H5 to H4 - should be blocked as a pawn is there
                    x=7; y=5;
                    newX=7; newY = 4;
                break;
                
                case 4:
                    //Black Rook H5 to D5
                    x=7; y=5;
                    newX = 3; newY=5;
                break;
                
                case 5: 
                    //Black Rook D5 to A5
                    x=3; y=5;
                    newX=0; newY=5;
                break;
                
                case 6: 
                    //White Pawn A1 to A3
                    x=0; y=1;
                    newX=0; newY=3;
                break;
                
                case 7: 
                    //White Rook A0 to A2
                    x=0; y=0;
                    newX=0; newY=2;
                break;
                
                case 8:
                    //Black Room A5 to A3
                    x=0; y=5;
                    newX=0; newY=3;
                break;
                
                case 9:
                    //Black Room A3 to A4 
                    x=0; y=3;
                    newX=0; newY=4;
                break;
                
                case 10:
                    //White Room A2 to A4 
                    x=0; y=2;
                    newX=0; newY=4;
                break;
            }
            Chess.warp(x, y, newX, newY, board);
            turnNumber++;
        } while (turnNumber < 12);
        
        
    }
}
