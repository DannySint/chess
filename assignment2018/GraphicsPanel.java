package assignment2018;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/**
 * Class to draw the layout of the board and the images in their respective locations 
 * @author Danny
 *
 */
public class GraphicsPanel extends JPanel {

    private Board board;
    private int maxX = 900;
    private int maxY = 900;

    BufferedImage blackKing = null;
    BufferedImage blackQueen = null;
    BufferedImage blackRook = null;
    BufferedImage blackBishop = null;
    BufferedImage blackKnight = null;
    BufferedImage blackPawn = null;
    BufferedImage whiteKing = null;
    BufferedImage whiteQueen = null;
    BufferedImage whiteRook = null;
    BufferedImage whiteBishop = null;
    BufferedImage whiteKnight = null;
    BufferedImage whitePawn = null;
    private HashMap<Character, BufferedImage> imageLookup = new HashMap<>();

    public GraphicsPanel(Board board) {
        this.setPreferredSize(new Dimension(this.maxX, this.maxY));
        this.setBackground(Color.WHITE);
        this.board = board;
        String path = "./src/assignment2018/images/";
        try {
            this.blackKing = ImageIO.read(new File(path + "BlackKing.png"));
            this.blackQueen = ImageIO.read(new File(path + "BlackQueen.png"));
            this.blackRook = ImageIO.read(new File(path + "BlackRook.png"));
            this.blackBishop = ImageIO.read(new File(path + "BlackBishop.png"));
            this.blackKnight = ImageIO.read(new File(path + "BlackKnight.png"));
            this.blackPawn = ImageIO.read(new File(path + "BlackPawn.png"));
            this.whiteKing = ImageIO.read(new File(path + "WhiteKing.png"));
            this.whiteQueen = ImageIO.read(new File(path + "WhiteQueen.png"));
            this.whiteRook = ImageIO.read(new File(path + "WhiteRook.png"));
            this.whiteBishop = ImageIO.read(new File(path + "WhiteBishop.png"));
            this.whiteKnight = ImageIO.read(new File(path + "WhiteKnight.png"));
            this.whitePawn = ImageIO.read(new File(path + "WhitePawn.png"));
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageLookup.put(PieceCode.PAWNWHITE, whitePawn);
        imageLookup.put(PieceCode.KNIGHTWHITE, whiteKnight);
        imageLookup.put(PieceCode.BISHOPWHITE, whiteBishop);
        imageLookup.put(PieceCode.ROOKWHITE, whiteRook);
        imageLookup.put(PieceCode.QUEENWHITE, whiteQueen);
        imageLookup.put(PieceCode.KINGWHITE, whiteKing);
        imageLookup.put(PieceCode.PAWNBLACK, blackPawn);
        imageLookup.put(PieceCode.KNIGHTBLACK, blackKnight);
        imageLookup.put(PieceCode.BISHOPBLACK, blackBishop);
        imageLookup.put(PieceCode.ROOKBLACK, blackRook);
        imageLookup.put(PieceCode.QUEENBLACK, blackQueen);
        imageLookup.put(PieceCode.KINGBLACK, blackKing);
        this.setVisible(true);
    }

    public static void main(String[] args) 
    {
        JFrame frm = new JFrame();
        frm.setContentPane(new GraphicsPanel(new Board()));
        frm.pack();
        frm.setVisible(true);
        frm.repaint();
    }

    public void paintComponent(Graphics g) 
    {
        //Display Board Squares
        for (int i=1; i < 9; i++) 
        {
            for (int j = 1; j < 9; j++) 
            {
                if ((i + j) % 2 == 0) 
                {   
                    g.setColor(Color.WHITE);
                }
                else if ((i+j) % 2 != 0)
                {
                    g.setColor(Color.GRAY);
                }
                g.fillRect((i * (this.maxX / 9)), (j * (this.maxY / 9)), (i * (this.maxX / 9)) + (this.maxX / 9),
                        (j * (this.maxY / 9)) + (this.maxY / 9));
            }
        }

        //Display Piece position on board
        for (int i=0; i < 8; i++) 
        {
            for (int j=0; j < 8; j++) 
            {
                Piece p = board.getPiece(i, j);
                if (p != null) 
                {
                    BufferedImage img = imageLookup.get(p.getChar());
                    g.drawImage(img, (i * 100) + 100, (j * 100) + 100, this);
                }
            }
        }
    }
}