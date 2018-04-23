package assignment2018;

import org.junit.Test;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class TestBishop 
{
    Chess chess = new Chess();
    int x, y, newX, newY = 0;
    Board board;
    Move move;
    Boolean legal;
    
    @Before
    public void setup()
    {
        legal = false;
    }
    
    @Test
    public void testBishop()
    {
        int turnNumber = 1;
        do
        {
            System.out.println(turnNumber);
            switch (turnNumber)
            {
                case 1: 
                    //Pawn E1 to E3
                    x=4; y=1;
                    newX=4; newY=3;
                break;
        
                case 2:
                   assertEquals(legal, true);
                   //Bishop F0 to E1
                   x=5; y=0;
                   newX=4; newY=1;
                break;
        
                case 3: 
                   //Bishop E1 to C3
                   x=4; y=1;
                   newX=2; newY=3;
                break;
        
                case 4: 
                   //Bishop C3 to B4
                   x=2; y=3;
                   newX=1; newY=4;
                break;
        
                case 5: 
                    //Bishop B4 to D6
                    x=1; y=4;
                    newX=3; newY= 6;
                break;
              
                case 6:
                    //Bishop B4 to D6
                    x=3; y=6;
                    newX=1; newY=4;
                break;
            }
            legal = chess.warp(x, y, newX, newY);
            turnNumber++;
        //} while (!chess.kingTaken());
        } while (turnNumber < 13);
        chess.updateTextDisplay();
    }
}
