package assignment2018;

import assignment2018.codeprovided.Player;

/**
 * Main class of Chess where the game runs off
 * 
 * @author Danny
 * Start @date 19th April 2018
 * End @date 1st May 2018
 */
public class Chess 
{
    
    //instance variables
    private Board board;
    private TextDisplay display;
    private GraphicsDisplay graphicsDisplay;
    private Player white;
    private Player black;
    private int turnNumber;
    private boolean legal;
    private enum Winner {WHITE, BLACK, NONE};
    private Winner winner;

    /**
     * Constructor for chess that constructs chess object with:
     * the board, the displays, the players with their pieces
     */
    public Chess()
    {
        //construct board
        board = new Board();
        
        //construct display
        display = new TextDisplay();
        graphicsDisplay = new GraphicsDisplay(board);
        
        //construct 2 players
        white = new RandomPlayer("White", board.getWhite(), board, black);
        black = new AggressivePlayer("Black", board.getBlack(), board, white);
        
        white.setOpponent(black);
        turnNumber = 0;
    }
    
    /**
     * Main game loop is run here.
     * Writes instructions for users
     * Initialises current player as white 
     * Updates graphics and texts display
     * loops if user's move is invalid
     * Checks if a king is taken each turn and if so ends
     */
    public void run()
    {
        //Instructions for user
        System.out.println("White is top 2 rows A0 to H1");
        System.out.println("Black is bottom 2 rows A6 to H7");
        System.out.println("Lowercase letters are white. Uppercase letters are black.");
        System.out.println("R is Rook");
        System.out.println("N is Knight");
        System.out.println("B is Bishop");
        System.out.println("Q is Queen");
        System.out.println("K is King");
        System.out.println("P is Pawn");
        System.out.println("Enter inputs in the form \"H1 H3\" to move a white Pawn from H1 to H3");
        Player current = white;
        //Game loop ending if a king is taken
        updateTextDisplay();
        updateGraphicsDisplay();
        do 
        {
            turnNumber++;
            System.out.println("Turn Number: " + turnNumber);
            legal = false; //reset legal (just in case)
            
            legal = current.makeMove();
            if (legal)
            {
                current = current.getOpponent();
            }
            updateTextDisplay();
            updateGraphicsDisplay();
            
        } while (kingTaken() == Winner.NONE);
        //} while (turnNumber(turnNumber) <= 12);
        graphicsDisplay.reset();
        
    }
	
    /**
     * Originally for the actual movement, this piece of code is now used for the test classes.
     * @param x current x position of piece
     * @param y current y position of piece
     * @param newX hopeful x position of piece
     * @param newY hopeful y position of piece
     * @return whether the move was legal or not
     */
	public boolean warp(int x, int y, int newX, int newY) 
	{
        Move move = new Move(board.getPiece(x, y), x, y, newX, newY, false);
        //System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
        System.out.println("Piece " + board.getPiece(x, y) + " at position: (" + x + ", " + y + ") moving to (" + newX + ", " + newY+ ")");
        if (board.getPiece(move.getX(), move.getY()) != null)
        {
            legal = move.movePiece(board);
            System.out.println("Legal: " + legal);
            if (legal) 
                {board.getPiece(x, y).setPosition(newX, newY);}
        }
        return legal;
	}
	
    /**
     * Display the board via the console.
     * Adds the pieces to the board
     * Then displays them.
     */
    public void updateTextDisplay() 
    {          
        display.addPieces(board.getWhite());
        display.addPieces(board.getBlack());
        display.displayBoard(board.getWhite()); //shouldn't need the pieces to display the board. 
        //I don't know why this is a thing. I've thought about this and I don't really want to update the board each turn
        //for each player's pieces. Its a nice concept but really unnecessary.
    }
    
    /**
     * Updates the graphical user interface
     */
    public void updateGraphicsDisplay()
    {
        graphicsDisplay.showBoard(board);
    }
	/**
	 * @return winner.NONE while the game's still running, 
	 * @return winner.BLACK if black has won or 
	 * @return winner.WHITE if white has won
	 */
    public Winner kingTaken() 
    {
        boolean whiteKing = false;
        boolean blackKing = false;
        Winner winner = Winner.NONE;
        for (int piece=0; piece < board.getWhite().getNumPieces(); piece++)
        {
            if (board.getWhite().getPiece(piece).getChar() == 'k')
            {
                whiteKing = true;
                break;
            }
        }
        
        for (int piece=0; piece < board.getBlack().getNumPieces(); piece++)
        {
            if (board.getBlack().getPiece(piece).getChar() == 'K')
            {
                blackKing = true;
            }
        }
        if (whiteKing && blackKing) {winner = Winner.NONE;}
        if (!whiteKing) {winner = Winner.BLACK;}
        if (!blackKing) {winner = Winner.WHITE;}
        this.winner = winner;
        return winner;
    }
	
	/**
     * Congratulations are in order to the grand winner of the 2018 Chess Tournament
     */
    public void omedeto() //congratulations
    {
        if (winner == Winner.BLACK) {System.out.println("Congratulations black team");}
        else if (winner == Winner.WHITE) {System.out.println("Congratulations to white team");}
        else {System.out.println("Nobody won or idk wtf happened");}
    }
	
   public static void main(String[] args) 
    {
       Chess chess = new Chess();
       chess.run();
       chess.omedeto(); //omedeto means congratulations
    }
}
