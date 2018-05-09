package assignment2018.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import assignment2018.Board;
import assignment2018.Chess;
import assignment2018.Move;

public class TestPieces 
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
    public void testB()
    {
        TestBishop testBishop = new TestBishop();
        testBishop.testBishop();
    }
    
    @Test
    public void testKing()
    {
        TestKing testKing = new TestKing();
        testKing.testKing();
    }
    
    @Test
    public void testKnight()
    {
        TestKnight testKnight = new TestKnight();
        testKnight.testKnight();
    }
    
    @Test
    public void testQueenCheckmate()
    {
        TestQueenCheckmate testQueenCheckmate = new TestQueenCheckmate();
        testQueenCheckmate.testQueenCheckmate();
    }
    
    @Test
    public void testPawnRook()
    {
        TestPawnRook testPawnRook = new TestPawnRook();
        testPawnRook.testPawns();
    }
}
