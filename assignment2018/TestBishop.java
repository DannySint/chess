package assignment2018;

public class TestBishop 
{
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
           //Bishop F0 to E1
           x=5; y=0;
           move = new Move(board.getPiece(x, y), x, y, 4, 1, false);
           System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
           if (board.getPiece(move.getX(), move.getY()) != null)
           {
               legal = move.movePiece(board);
               System.out.println("Legal: " + legal);
               if (legal) 
                   {board.getPiece(x, y).setPosition(4, 1);}
           }
       break;
       
      case 3: 
          //Bishop E1 to C3
          x=4; y=1;
          move = new Move(board.getPiece(x, y), x, y, 2, 3, false);
          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
          if (board.getPiece(move.getX(), move.getY()) != null)
          {
              legal = move.movePiece(board);
              System.out.println("Legal: " + legal);
              if (legal) 
                  {board.getPiece(x, y).setPosition(2, 3);}
          }
      break;
      
      case 4: 
          //Bishop C3 to B4
          x=2; y=3;
          move = new Move(board.getPiece(x, y), x, y, 1, 4, false);
          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
          if (board.getPiece(move.getX(), move.getY()) != null)
          {
              legal = move.movePiece(board);
              System.out.println("Legal: " + legal);
              if (legal) 
                  {board.getPiece(x, y).setPosition(1, 4);}
          }
      break;
      
      case 5: 
          //Bishop B4 to D6
          x=1; y=4;
          move = new Move(board.getPiece(x, y), x, y, 3, 6, false);
          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
          if (board.getPiece(move.getX(), move.getY()) != null)
          {
              legal = move.movePiece(board);
              System.out.println("Legal: " + legal);
              if (legal) 
                  {board.getPiece(x, y).setPosition(3, 6);}
          }
          System.out.println(board.getBlack().getNumPieces());
          System.out.println(board.getWhite().getNumPieces());
      break;
      
      case 6:
          //Bishop B4 to D6
          x=3; y=6;
          move = new Move(board.getPiece(x, y), x, y, 1, 4, false);
          System.out.println("Piece at "+x+", "+y+": " + board.getPiece(x, y));
          if (board.getPiece(move.getX(), move.getY()) != null)
          {
              legal = move.movePiece(board);
              System.out.println("Legal: " + legal);
              if (legal) 
                  {board.getPiece(x, y).setPosition(1, 4);}
          }
      break;
    }
}
