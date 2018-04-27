package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

public class Board {
    private Pieces white;
    private Pieces black;
    private Piece[][] board = new Piece[PieceCode.XSIZE][PieceCode.YSIZE];

    /**
     * Constructor method to add both sets of pieces to the board
     */
    public Board() {
        // create pieces
        white = new Pieces(this, PieceCode.WHITE);
        black = new Pieces(this, PieceCode.BLACK);
    }

    /**
     * Method to set the position of a piece
     * If the occupying piece is a different colour from the moving piece the opposing piece is deleted  
     * @param x
     * @param y
     * @param thePiece
     */
    public boolean setPosition(int x, int y, Piece thePiece) 
    {
        if (board[x][y] == null) //if board is empty
        {
            thePiece.setPosition(x, y);
            return true;
        }
        else if ((board[x][y] != null) && (board[x][y].getColourChar() == thePiece.getColourChar()))
        //if piece is same colour as occupied pieces
        {
            return false;
        }
        else if ((board[x][y] != null) && board[x][y].getColourChar() != thePiece.getColourChar())
        {
            switch (board[x][y].getColourChar())
            {
            case 'b' :
                black.delete(board[x][y]);
            break;
            case 'w' :
                white.delete(board[x][y]);
            break;
            }
            thePiece.setPosition(x, y);
            return true;
        }
        return false;
    }

    /**
     * Method that checks if user supplied coordinates are outside of the board's
     * range
     * 
     * @param x
     *            is the passed x coordinate
     * @param y
     *            is the passed y coordinate
     * @return true if coordinates are out of range
     * @return false if coordinates are fine
     */
    public boolean outOfRange(int x, int y) {
        if (x > 7 || x < 0) {
            return true;
        } // if ((x>7 || x<0) && (y>7 || y<0)) {return true;} else {return false;}
        if (y > 7 || y < 0) {
            return true;
        }
        return false;
    }

    public void insertPiece() {
    }

    public void removePiece() {
    }

    /**
     * Method to return what piece is at a particular location
     * 
     * @param x
     *            is the passed x coordinate
     * @param y
     *            is the passed y coordinate
     * @return the piece if exists among white or black
     * @return null if no piece exists at particular location
     */
    public Piece getPiece(int x, int y) {
        if (occupied(x, y)) {
            for (int i = 0; i < white.getNumPieces(); i++) 
            {
                if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) 
                {
                    return white.getPiece(i);
                }
            }
            
            for (int i = 0; i < black.getNumPieces(); i++)
            {
                if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) 
                {
                    return black.getPiece(i);
                }
            }
        }
        return null;
    }

    // returns state of board
    public Board getBoard() 
    {
        return this;
    }

    public Piece[][] returnBoard() 
    {
        return board;
    }

    public Pieces getWhite() 
    {
        return white;
    }

    public Pieces getBlack() 
    {
        return black;
    }

    /**
     * Method to check if a space is occupied
     * 
     * @param x
     *            is passed x coordinate
     * @param y
     *            is passed y coordinate
     * @return true if a piece exists
     * @return false if no piece exists
     */
    public boolean occupied(int x, int y) 
    {
        for (int i = 0; i < white.getNumPieces(); i++) 
        {
            if ((white.getPiece(i).getX() == x) && (white.getPiece(i).getY() == y)) 
            {
                return true;
            }
        }
        for (int i = 0; i < black.getNumPieces(); i++) 
        {
            if ((black.getPiece(i).getX() == x) && (black.getPiece(i).getY() == y)) 
            {
                return true;
            }
        }
        return false;
    }

}
