package assignment2018;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestKing 
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
    public void testKing()
    {
        int turnNumber = 1;
        do
        {
            switch (turnNumber)
            {
               case 1: 
                   //Pawn E1 to E3
                   x=4; y=1;
                   newX = 4; newY = 3;
               break;
                
               case 2:
                   assertEquals(legal, true);
                   //King E0 to E1
                   x=4; y=0;
                   newX = 4; newY = 1;
               break;
                
               case 3:
                   assertEquals(legal, true);
                   //King E1 to E2
                   x=4; y=1;
                   newX = 4; newY = 2;
               break;
               
               case 4: 
                   assertEquals(legal, true);
                   //King E2 to F2
                   x=4; y=2;
                   newX = 5; newY = 2;
               break;
               
               case 5: 
                   assertEquals(legal, true);
                   //King F2 to F3
                   x=5; y=2;
                   newX = 5; newY = 3;
               break;
               
               case 6: 
                   assertEquals(legal, true);
                   //King F3 to F4
                   x=5; y=3;
                   newX = 4; newY = 4;
               break;
               
               case 7: 
                   assertEquals(legal, true);
                   //King F3 to E4
                   x=5; y=3;
                   newX = 4; newY = 4;
               break;
               
               case 8: 
                   assertEquals(legal, true);
                   //King F3 to E4
                   x=5; y=3;
                   newX = 4; newY = 4;
               break;
               
               case 9:
                   assertEquals(legal, true);
               break;
            }
            legal = chess.warp(x, y, newX, newY);
            System.out.println(legal);
            turnNumber++;
        //} while (!chess.kingTaken());
            chess.updateTextDisplay();
        } while (turnNumber < 13);
        
    }
}
