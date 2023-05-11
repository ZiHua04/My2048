package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class My2048 extends JPanel implements KeyListener
{
    public static final int SIZE = 400;
    public static final int high = 400;
    public static final int width = 500;


    private boolean moveing = false;

    public static BufferedImage[] images;
    public static String path = "my2048\\src\\game\\DOG.png";
    static
    {
        try{
            for(int i = 0; i < 12; i++){
                images[i] = ImageIO.read(new FileInputStream(path));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public void paint(Graphics g)
    {
        paintArrays(g);//画数组
        paintScore(g);//
        paintButton(g);
    }
    public void paintArrays(Graphics g)
    {

    }
    public void paintScore(Graphics g){

    }
    public void paintButton(Graphics g)
    {

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("2048");
        My2048 my2048 = new My2048();
        frame.add(my2048);
        frame.setSize(width,high);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(!moveing){
            moveing = true;
            
        }
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }

    
}