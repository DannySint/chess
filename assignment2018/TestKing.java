package assignment2018;

public class TestKing {
    switch (turnNumber)
    {
       case 1: 
           //Pawn E1 to E3
           x=4; y=1;
           move = new Move(board.getPiece(x, y), x, y, 4, 3, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               if (legal) 
                   {board.getPiece(x, y).setPosition(4, 3);}
           }
       break;
        
       case 2: 
           //King E0 to E1
           x=4; y=0;
           move = new Move(board.getPiece(x, y), x, y, 4, 1, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               if (legal) 
                   {board.getPiece(x, y).setPosition(4, 1);}
           }
       break;
        
       case 3: 
           //King E1 to E2
           x=4; y=1;
           move = new Move(board.getPiece(x, y), x, y, 4, 2, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               if (legal) 
                   {board.getPiece(x, y).setPosition(4, 2);}
           }
       break;
       case 4: 
           //King E2 to F2
           x=4; y=2;
           move = new Move(board.getPiece(x, y), x, y, 5, 2, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               if (legal) 
                   {board.getPiece(x, y).setPosition(5, 2);}
           }
       break;
       
       case 5: 
           //King F2 to F3
           x=5; y=2;
           move = new Move(board.getPiece(x, y), x, y, 5, 3, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               if (legal) 
                   {board.getPiece(x, y).setPosition(5, 3);}
           }
       break;

        
    }
}
