package assignment2018;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

/**
 * Image source: https://cdn.pixabay.com/photo/2012/04/10/22/54/chess-26774_960_720.png
 * Free for commercial use - edited by Danny
 * @author Danny
 *
 */
public class GraphicsDisplay extends JFrame implements Display
{
    private Board board;
    private static final String text = " ABCDEFGH";
    private Container contentPane;
    private int[] coords;
    private String pieceCode = "";
    private JLabel[][] labels;
    private JMenuBar menuBar;
    private JMenu menu;
    private int maxX = 900;
    private int maxY = 900;
    private JPanel chessboard;
    
    
    
    public GraphicsDisplay(Board board)
    {
        this.board = board;
        this.setTitle("Chess");
        this.setSize(maxX,maxY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("New Game");
        this.chessboard = new GraphicsPanel(board);
        this.add(chessboard);
        chessboard.setPreferredSize(new Dimension(900, 900));
        labels = new JLabel[9][9];
    }
    public void displayBoard(Pieces pieces) {}
    public void showBoard(Board board)
    {
//        this.setJMenuBar(menuBar);
        
        chessboard.invalidate();
        chessboard.repaint();
         
    }
    
    public void updateBoard(Board board)
    {
        this.board = board;
    }
    
    public String coordsToPieceCode(Board board, int x, int y)
    {
        PieceCode pieceCode = new PieceCode();
        if (board.getPiece(y, x) == null) {return null;}
        switch(board.getPiece(y, x).getChar())
        {
            //white
            case 'p': return "WHITE_PAWN";
            case 'r': return "WHITE_ROOK";
            case 'b': return "WHITE_BISHOP";
            case 'n': return "WHITE_KNIGHT";
            case 'q': return "WHITE_QUEEN";
            case 'k': return "WHITE_QUEEN";
            //black
            case 'P': return "BLACK_PAWN";
            case 'R': return "BLACK_ROOK";
            case 'B': return "BLACK_BISHOP";
            case 'N': return "BLACK_KNIGHT";
            case 'Q': return "BLACK_QUEEN";
            case 'K': return "BLACK_KING";
        }
        return null;
    }
    
    public void reset()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void clearBoard()
    {
        labels = null;
        contentPane.removeAll();
    }
}
