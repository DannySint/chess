package assignment2018;

import org.junit.Before;
import org.junit.Test;

public class TestKnight 
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
    public void testKnight()
    {
        int turnNumber = 1;
        do
        {
    
            switch (turnNumber)
            {
            case 1:
                //Knight B7 to D6
                x=1; y=7;
                newX=4; newY=1;
            break;
            
            case 2:
                //Knight B7 to A5
                x=1; y=7;
                newX=0; newY=5;
            break;
            
            case 3:
                //Knight A5 to C4
                x=0; y=5;
                newX=2; newY=4;
            break;
            
            case 4:
                //Knight C4 to D2
                x=2; y=4;
                newX=3; newY=2;
            break;
            
            case 5:
                //Knight to D2 to E0
                x=3; y=2;
                newX=4; newY=0;
            break;
            
            case 6:
                //Knight to E0 to F2
                x=4; y=0;
                newX=5; newY=2;
            break;
            
            }
            turnNumber++;
            legal = chess.warp(x, y, newX, newY);
            System.out.println(legal);
            turnNumber++;
        //} while (!chess.kingTaken());
            chess.updateTextDisplay();
        } while (turnNumber < 13);
    }
}