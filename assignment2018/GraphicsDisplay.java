package assignment2018;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.PieceCode;
import assignment2018.codeprovided.Pieces;

/**
 * GraphicsDisplay class 
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
    private int maxX = 920;
    private int maxY = 950;
    private JPanel chessboard;
    
    public GraphicsDisplay(Board board)
    {
        this.board = board;
        this.setTitle("Chess");
        this.setSize(maxX,maxY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("New Game");
        this.chessboard = new GraphicsPanel(board);
        this.add(chessboard);
        chessboard.setPreferredSize(new Dimension(920, 950));
        labels = new JLabel[9][9];
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("New Game!", true);
        JMenu subWhiteMenu = new JMenu("White", true);
        JMenuItem WhiteXHuman = new JMenuItem("White vs Human");
        JMenuItem WhiteXRandom = new JMenuItem("White vs Random");
        JMenuItem WhiteXAggro= new JMenuItem("White vs Aggressive");
        subWhiteMenu.add(WhiteXHuman);
        subWhiteMenu.add(WhiteXRandom);
        subWhiteMenu.add(WhiteXAggro);
        JMenu subBlackMenu = new JMenu("Black", true);
        JMenuItem BlackXHuman = new JMenuItem("Black vs Human");
        JMenuItem BlackXRandom = new JMenuItem("Black vs Random");
        JMenuItem BlackXAggro= new JMenuItem("Black vs Aggressive");
        subBlackMenu.add(BlackXHuman);
        subBlackMenu.add(BlackXRandom);
        subBlackMenu.add(BlackXAggro);
        
        //subMenu.add("Sub Item One");
        menu.add(subWhiteMenu);
        menu.add(subBlackMenu);
        menu.add("Exit");
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        //event listeners
        WhiteXHuman.addActionListener(new Listener());
        BlackXHuman.addActionListener(new Listener());
    }
    
    private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.out.println(event.getActionCommand());
            switch(event.getActionCommand())
            {
            case "White vs Human" :
                System.out.println(event.getActionCommand());
                Chess chess2 = new Chess("HH");
                chess2.run();
                chess2.congratulations();
                break;
                
            case "White vs Random" :
                System.out.println(event.getActionCommand());
                break;
            
            case "White vs Aggressive" :
                System.out.println(event.getActionCommand());
                break;
                
            case "Black vs Human" :
                System.out.println(event.getActionCommand());
                break;
                
            case "Black vs Random" :
                System.out.println(event.getActionCommand());
                break;
            
            case "Black vs Aggressive" :
                System.out.println(event.getActionCommand());
                break;
            
            case "Exit" :
                System.out.println(event.getActionCommand());
                System.exit(1);
                break;
                
            default:
                System.out.println(event.getActionCommand());
                break;
            }
        }
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
    
    public void reset()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }
}
