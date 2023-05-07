import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class my2048{
    public static class Dog{
        private 
            int x,y,high,width;
            Image image;
            int num;
        public Dog(){
            this.image = new ImageIcon("my2048\\src\\photos\\DOG.png").getImage();
            this.width = 100;
            this.high = 100;
            this.x = 0;
            this.y = 0;
            this.num = 2;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int xx){
            x = xx;
        }
        public void setY(int yy){
            y = yy;
        }
        

    }
    public static class MyPanel extends JPanel{
        private Dog dog;
        public MyPanel(Dog dog)
        {
            this.dog = dog;
        } 
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(dog.image, dog.x, dog.y,dog.width,dog.high, null);
        }

    }

    
    public static class MyFrame extends JFrame implements KeyListener{
        private Dog a,b;
        private MyPanel panel,panel2;
        private int speed = 5;
        private boolean moving = false;
        public MyFrame() throws InterruptedException{
            this.setTitle("2048");
            this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
            this.setSize(480,480);

            a = new Dog();
            b = new Dog();
            panel = new MyPanel(a);
            panel2 = new MyPanel(b);
            this.add(panel);
            this.addKeyListener(this);
            this.requestFocusInWindow();

            setVisible(true);
            
            
        }
        public void move(int flag){
            Thread thread = new Thread(){
                public void run(){
                    while(moving){
                        if(flag == 0){
                            if(a.getY() >= 330) moving = false;
                            a.setY(a.getY() + speed);
                            panel.repaint();
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else if(flag == 1){
                            if(a.getY() <= 0) moving = false;
                            a.setY(a.getY() - speed);
                            panel.repaint();
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else if(flag == 2){
                            if(a.getX() >= 330) moving = false;
                            a.setX(a.getX() + speed);
                            panel.repaint();
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else if(flag == 3){
                            if(a.getX() <= 0) moving = false;
                            a.setX(a.getX() - speed);
                            panel.repaint();
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        
                        
                    }
                }
            };
            thread.start();
        }
        public void keyTyped(KeyEvent e){}
        public void keyPressed(KeyEvent e){
            int KeyCode = e.getKeyCode();
            switch (KeyCode){
                case KeyEvent.VK_DOWN:{
                    if(!moving){
                        moving = true;
                        move(0);
                        break;
                    }
                }
                case KeyEvent.VK_UP:{
                    if(!moving){
                        moving = true;
                        move(1);
                        break;
                    }
                }
                case KeyEvent.VK_RIGHT:{
                    if(!moving){
                        moving = true;
                        move(2);
                        break;
                    }
                }
                case KeyEvent.VK_LEFT:{
                    if(!moving){
                        moving = true;
                        move(3);
                        break;
                    }
                }
            }
        }
        public void keyReleased(KeyEvent e){}
        

        
    }
    public static void main(String[] args) throws InterruptedException{
        new MyFrame();
    }
}
