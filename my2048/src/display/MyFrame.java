package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import arrays.*;

public class MyFrame extends JFrame implements KeyListener
{
    private Arrays arrays;
    private int SIZE = 400;
    //private MyPanel[][] a;
    public MyFrame()
    {
        setTitle("My2048");
        setSize(SIZE, SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        arrays = new Arrays();
        arrays.addNewTile();
        arrays.addNewTile();
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                //a[i][j] = new MyPanel(i*100, j*100, 0);
            }
        }

        setVisible(true);
        addKeyListener(this);
    }
    private void drawArrays(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 400);
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                //a[i][j].drawTile(g);
            }
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawArrays(g);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
        System.out.println("Preesed");
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
            arrays.moveDown();
            break;
         case KeyEvent.VK_UP:
            arrays.moveUp();
            break;
        case KeyEvent.VK_LEFT:
            arrays.moveLeft();
            break;
        case KeyEvent.VK_RIGHT:
            arrays.moveRight();
            break;
        case KeyEvent.VK_Z:
            arrays.backArrays();
            break;
        }
        arrays.ShowArraysBefore();
        arrays.ShowArrays();
       
        
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
       
    }
    
}