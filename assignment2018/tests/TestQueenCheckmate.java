package assignment2018.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import assignment2018.Board;
import assignment2018.Chess;
import assignment2018.Move;
import assignment2018.Chess.Winner;

public class TestQueenCheckmate 
{
    Chess chess = new Chess("");
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
    public void testQueenCheckmate() 
    {
        int turnNumber = 1;
        do
        {
            System.out.println(turnNumber);
            switch (turnNumber)
            {
                case 1: 
                    //White Pawn E1 to E3
                    x=4;y=1;
                    newX=4; newY=3;
                break;
                
                case 2:
                    assertEquals(legal, true); //previous move btw
                    //Black Pawn E6 E5
                    x=4; y=6;
                    newX=4; newY=5;
                break;
                
                case 3:
                    assertEquals(legal, true);
                    //White Queen D0 to H4
                    x=3; y=0;
                    newX=7; newY = 4;
                break;
                
                case 4:
                    assertEquals(legal, true);
                    //Black Pawn F6 to F4
                    x=5; y=6;
                    newX = 5; newY=4;
                break;
                
                case 5:
                    assertEquals(legal, true);
                    //White Queen H4 to F7
                    x=7; y=4;
                    newX = 4; newY = 7;
                break;

            }
            legal = chess.warp(x, y, newX, newY);
            turnNumber++;
            chess.updateTextDisplay();
        } while (chess.kingTaken() == Chess.Winner.NONE);
    }
}
