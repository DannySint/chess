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
        this.setPreferredSize(new Dimension(900,900));
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
        super.paintComponent(g);
        
        for (int i=0; i < 8; i++)
        {
            for (int j=0; j < 8; j++)
            {
                if ((i + j)  % 2 == 0)
                {
                    g.setColor(Color.WHITE);
                }
                else
                {
                    g.setColor(Color.GRAY);
                }
                g.fillRect((i*maxX/9), (j*maxY/9), (i*this.maxX/9)+50, ((j*this.maxY/9))+50);
            }
        }
        
        BufferedImage blackKing = null;
        
        try {
            blackKing = ImageIO.read(new File("images/BlackKing.png"));
        } catch (IOException e) {
        }

        g.drawImage(blackKing, 50, 50, this);
    }
    
}
