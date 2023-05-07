import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class real2048 extends JPanel   {
    private static final long serialVersionUID = 1L;
    private final int SIZE = 4;
    private int[][] board;
    public real2048(){
        setPreferredSize(new Dimension(400,400));//设置大小
        setBackground(Color.WHITE);//设置背景颜色
        setFont(new Font("Arial",Font.BOLD,32));//设置字体
        setLayout(new BorderLayout());//设置摆放方式

        board = new int[SIZE][SIZE];

        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()){
                    case KeyEvent.VK_DOWN:{
                        moveDown();
                        mergeDown();
                        addNewTile();
                        break;
                    }
                    
                }
                repaint();
            }
            
        });
        addNewTile();
        addNewTile();
        
    }
    private void addNewTile(){
        int x,y;
        do{
            x = (int)(Math.random() * SIZE);
            y = (int)(Math.random() * SIZE);
        }while(board[x][y] != 0);
        board[x][y] = Math.random() <= 0.9?2:4;
    }
    private void moveDown(){
        for(int x = 0; x < SIZE; x++){
            for(int y = SIZE-2; y >= 0; y--){
                if(board[x][y] != 0){
                    int py = y;
                    while(py < SIZE-1 && board[x][py+1] == 0){
                        board[x][py+1] = board[x][py];
                        board[x][py] = 0;
                        py++;
                    }
                }
            }
        }
    }
    private void mergeDown(){
        for(int x = 0; x < SIZE; x++){
            for(int y = SIZE-2; y >= 0; y--){
                if(board[x][y] != 0 && board[x][y] == board[x][y+1]){
                    board[x][y+1] *= 2;
                    board[x][y] = 0;
                }
            }
        }
    }
    private Color getTileColor(int tile){
        switch (tile){
            case 2: return new Color(238, 228, 218);
            default:{
                return new Color(204, 192, 179);
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int y = 0; y < SIZE; y++){
            for(int x = 0; x < SIZE; x++){
                g.setColor(getTileColor(board[x][y]));//设置框框颜色
                g.fillRect(x * getWidth() / SIZE, y * getHeight() / SIZE, getWidth() / SIZE, getHeight() / SIZE);
                g.setColor(Color.BLACK);//设置颜色
                g.drawRect(x * getWidth() / SIZE, y * getHeight() / SIZE, getWidth() / SIZE, getHeight() / SIZE);
                if(board[x][y] != 0){
                    String s = "" + board[x][y];
                    FontMetrics fm = g.getFontMetrics();
                    int tx = x * getWidth() / SIZE + (getWidth() / SIZE - fm.stringWidth(s)) / 2;
                    int ty = y * getHeight() / SIZE + (getHeight() / SIZE + fm.getAscent()) / 2;//文本位置
                    g.setColor(Color.WHITE);
                    g.drawString(s, tx, ty);
                }
            }
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("2048");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        real2048 game = new real2048();
        frame.getContentPane().add(game);//将panel添加进frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.requestFocus();

    }
}
