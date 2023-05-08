package display;

import javax.swing.*;
import java.awt.event.*;
import arrays.*;

public class MyFrame extends JFrame implements KeyListener
{
    private Arrays arrays;
    private int SIZE = 400;
    public MyFrame()
    {
        setTitle("My2048");
        setSize(SIZE, SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        arrays = new Arrays();
        arrays.addNewTile();
        arrays.addNewTile();

        setVisible(true);
        addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Preesed");
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
            
            break;
         case KeyEvent.VK_UP:
           
            break;
        case KeyEvent.VK_LEFT:
            
            break;
        case KeyEvent.VK_RIGHT:
            
            break;
        case KeyEvent.VK_Z:
            
            break;
        }
        arrays.ShowArrays();
        
        System.out.println();
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
}