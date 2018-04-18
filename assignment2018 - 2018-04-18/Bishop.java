package assignment2018;

import java.util.ArrayList;

import assignment2018.*;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

public class Bishop extends Piece 
{

    public Bishop(int ix, int iy, int c, Board b) 
    {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() 
    {
        return null;
    }

}