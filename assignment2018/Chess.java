package assignment2018;

/**
 * Main class of Chess where the game runs off
 * 
 * @author Danny
 * 19th April 2018
 */
public class Chess 
{
    
    private static Board board;
    private static TextDisplay display;
    private static Move move;
    private static HumanPlayer white;
    private static RandomPlayer black;
    private static int turnNumber;
    private static boolean legal;
    
    private static String from = "";
    private static String to = "";
    private static int[] jump;
    
    private static int x = 0;
    private static int y = 0;
    private static int newX = 0; 
    private static int newY = 0;
    
    public static void init()
    {
        //construct board
        board = new Board();
        
        //construct display
        display = new TextDisplay();
        
        //construct 2 players
        white = new HumanPlayer("Jeanne d'Arc", board.getWhite(), board, black);
        black = new RandomPlayer("Amakusa Shirou Tokisada", board.getBlack(), board, white); //don't look up these names if you haven't seen Fate
        turnNumber = 0;
    }
    
    public static boolean run()
    {
        x=0;
        y=0; 
        newX=0;
        newY=0;
      //Game loop ending if a king is taken 
        do 
        {
            updateDisplay(display, board);
            legal = false; //reset legal (just in case)
            
            switch((turnNumber % 2))
            {
            case 0:
                jump = white.requestMove();
            break;
                
            case 1:
                jump = black.requestMove();
            break;
            }
            warp(jump[0], jump[1], jump[2], jump[3], board);
        turnNumber++;
        //while (!kingTaken());
        } while (turnNumber(turnNumber) <= 12);
        
        return false;
    }
	
	public static void warp(int x, int y, int newX, int newY, Board board) 
	{
        Move move = new Move(board.getPiece(x, y), x, y, newX, newY, false);
        //System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
        System.out.println("Piece " + board.getPiece(x, y) + " at position: (" + x + ", " + y + ") moving to (" + newX + ", " + newY+ ")");
        if (board.getPiece(move.getX(), move.getY()) != null)
        {
            boolean legal = move.movePiece(board);
            System.out.println("Legal: " + legal);
            if (legal) 
                {board.getPiece(x, y).setPosition(newX, newY);}
        }
	}

    public static boolean kingTaken() {return false;} //temporary method
	public static int turnNumber(int turnNumber) {turnNumber++; return turnNumber;}
	public static void updateDisplay(TextDisplay display, Board board) 
	{          
	    display.addPieces(board.getWhite());
	    display.addPieces(board.getBlack());
	    display.displayBoard(board.getWhite()); //shouldn't need the pieces to display the board.
	}
	
   public static void main(String[] args) 
    {
        init();
        run();
    }
}
