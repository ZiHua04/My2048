package display;
import javax.swing.*;

import java.awt.*;
import arrays.*;
public class MyPanel extends JPanel
{  
    private int x,y,tile;
    public MyPanel(int x,int y, int tile)
    {
        this.x = x;
        this.y = y;
        this.tile = tile;
    }
    public void drawTile(Graphics g){
        Colors a = new Colors();
        g.setColor(a.getTileColor(tile));
        g.fillRect(x, y, 100, 100);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 100, 100);
        if (tile != 0) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            g.drawString(Integer.toString(tile), x + 35, y + 65);
        }
    }
}