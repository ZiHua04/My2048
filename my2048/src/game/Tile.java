package game;

import java.awt.Image;

public class Tile {
    private int x,y,num;
    private Image image;
    
    public Tile(int x,int y,int num)
    {
        this.x = x;
        this.y = y;
        this.num = num;
        this.image = My2048.images[num];
    }
    public void up()
    {
        x--;
    }
    public void down()
    {
        x++;
    }
    public void left()
    {
        y--;
    }
    public void right()
    {
        y++;
    }
}
