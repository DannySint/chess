package assignment2018;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsPanel extends JPanel {
    
    private Board board;
    private int maxX = 900;
    private int maxY = 900;
    public GraphicsPanel()
    {
        this.setPreferredSize(new Dimension(this.maxX,this.maxY));
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        
    }
    
    public static void main(String[] args)
    {
        JFrame frm = new JFrame();
        frm.setContentPane(new GraphicsPanel());
        frm.pack();
        frm.setVisible(true);
        frm.repaint();
    }
    
    public void paintComponent(Graphics g) 
    {
        for (int i = 1; i < 9; i++)
        {
            for (int j = 1; j < 9; j++)
            {
                if ((i + j)  % 2 == 0)
                {
                    g.setColor(Color.WHITE);
                }
                else
                {
                    g.setColor(Color.GRAY);
                }
                g.fillRect((i*100), (j*100), (i*100)+100, (j*100)+100);
                //g.fillRect((i*maxX/9), (j*maxY/9), (i*this.maxX/9)+50, ((j*this.maxY/9))+50);
            }
        }
        
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
        
        
        try {
            blackKing = ImageIO.read(new File("images/BlackKing.png"));
            blackQueen = ImageIO.read(new File("images/BlackQueen.png"));
            blackRook = ImageIO.read(new File("images/BlackRook.png"));
            blackBishop = ImageIO.read(new File("images/BlackBishop.png"));
            blackKnight = ImageIO.read(new File("images/BlackKnight.png"));
            blackPawn= ImageIO.read(new File("images/BlackPawm.png"));
            whiteKing = ImageIO.read(new File("images/WhiteKing.png"));
            whiteQueen = ImageIO.read(new File("images/WhiteQueen.png"));
            whiteRook = ImageIO.read(new File("images/WhiteRook.png"));
            whiteBishop = ImageIO.read(new File("images/WhiteBishop.png"));
            whiteKnight = ImageIO.read(new File("images/WhiteKnight.png"));
            whitePawn= ImageIO.read(new File("images/WhitePawn.png"));;
        } catch (IOException e) {
        }

        g.drawImage(blackKing, 50, 50, this);
        g.drawImage(blackQueen, 100, 100, this);
    }
    
}
