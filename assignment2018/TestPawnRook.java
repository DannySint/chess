package assignment2018;

public class TestPawnRook {
    
    public void testPawns(Board board) 
    {
        switch (turnNumber)
        {
        case 1: 
            //Pawn H6 to H4
            move = new Move(board.getPiece(7, 6), 7, 6, 7, 4, false);
            System.out.println("Piece at 7, 6: " + board.getPiece(7, 6));
            if (board.getPiece(move.getX(), move.getY()) != null)
            {
                legal = move.movePiece(board);
                if (legal) 
                    {board.getPiece(7, 6).setPosition(7, 4);}
            }
        break;
        
        case 2:
            //Rook H7 to H5
            move = new Move(board.getPiece(7, 7), 7, 7, 7, 6, false);
            if (board.getPiece(move.getX(), move.getY()) != null)
            {
                System.out.println("Piece at 7, 7: " + board.getPiece(7, 7));
                legal = move.movePiece(board);
                if (legal) 
                    {board.getPiece(7, 7).setPosition(7, 5);}
            }
        break;
        
        case 3: 
            //Rook H5 to H4 - should be blocked
              move = new Move(board.getPiece(7, 5), 7, 5, 7, 4, false);
              System.out.println(move.getX() + " " +  move.getY());
                if (board.getPiece(move.getX(), move.getY()) != null)
                {
                    System.out.println("Piece at 7, 5: " + board.getPiece(7, 5));
                    legal = move.movePiece(board);
                    System.out.println("Legal: " + legal);
                    if (legal) 
                        {board.getPiece(7, 5).setPosition(7, 4);}
                }
        break;
        
        case 4: 
            //White Pawn A1 to A3
              move = new Move(board.getPiece(0, 1), 0, 1, 0, 3, false);
              System.out.println(move.getX() + " " +  move.getY());
                if (board.getPiece(move.getX(), move.getY()) != null)
                {
                    System.out.println("Piece at 0, 1: " + board.getPiece(0, 1));
                    legal = move.movePiece(board);
                    System.out.println("Legal: " + legal);
                    if (legal) 
                        {board.getPiece(0, 1).setPosition(0, 3);}
                }
        break;
        
        case 5: 
            //White Rook A0 to A2
              move = new Move(board.getPiece(0, 0), 0, 0, 0, 2, false);
              System.out.println(move.getX() + " " +  move.getY());
                if (board.getPiece(move.getX(), move.getY()) != null)
                {
                    System.out.println("Piece at 0, 0: " + board.getPiece(0, 0));
                    legal = move.movePiece(board);
                    System.out.println("Legal: " + legal);
                    if (legal) 
                        {board.getPiece(0, 0).setPosition(0, 2);}
                }
        break;
    }
}
