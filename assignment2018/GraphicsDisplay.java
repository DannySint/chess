package assignment2018;

import java.awt.Color;
import java.awt.Container;
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
    private JLabel[] label;
    private JLabel[][] labels;
    private JMenuBar menuBar;
    private JMenu menu;
    private int maxX = 900;
    private int maxY = 900;
    
    
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
    }
    
    @Override
    public void displayBoard(Pieces pieces)
    {
        //Container
        contentPane = getContentPane();
        clearBoard();
        //JButton[] button = new JButton[4];
        /*for (int i = 0; i < button.length; i++) 
        {
            button[i] = new JButton("Hello");
            //contentPane.add(button[i]);
        }*/
        
        //contentPane.setLayout(new FlowLayout());
        
        //BufferedImage king = new BufferedImage("king.jpg");

         
        contentPane.setLayout(new GridLayout(9, 9));        
        
        char a = 'a';
        
        label = new JLabel[81];
        labels = new JLabel[9][9];
        
        for (int rows = 0; rows < labels.length; rows++)
        {
            for (int cols = 0; cols < labels[rows].length; cols++)
            {
                if (rows == 0)
                {
                    labels[rows][cols] = new JLabel(String.valueOf(text.charAt(cols)) );// + "/" + (cols-1));
                }
                else if (cols % 9 == 0) 
                {
                    labels[rows][cols] = new JLabel("" + (rows-1));
                }
                else
                {
                    labels[rows][cols] = new JLabel("(" + rows + ", " + cols + ")");
                    pieceCode = coordsToPieceCode(board, (rows-1), (cols-1));
                    if (pieceCode != null)
                    {labels[rows][cols] = new JLabel(pieceCode);}
                    
                }
                contentPane.add(labels[rows][cols]);
            }
        }
        
        //Menu stuff 
        
        this.setJMenuBar(menuBar);
         
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
