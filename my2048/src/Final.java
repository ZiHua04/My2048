

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.*;


public class Final  extends JFrame implements KeyListener{
    private int[][] board;
    private int[][] boardBefore;
    private final int SIZE = 4;

    public Final(){
        board = new int[SIZE][SIZE];
        boardBefore = new int[SIZE][SIZE];
        
        addNewTile();
        addNewTile();

        setTitle("2048");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        

        addKeyListener(this);
    }
    public void CopyArrays(int[][] a, int[][] b, int size)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                a[i][j] = b[i][j];
            }
        }

    }
    public void addNewTile(){
        int x,y;
        do{
            x = (int)(Math.random()*SIZE);
            y = (int)(Math.random()*SIZE);
        }while(board[x][y] != 0);
        if(((int)Math.random())*10 % 2 == 0)
        {
            board[x][y] = 4;
        }
        else
        {
            board[x][y] = 2;
        }
        
    }


    private void drawTile(Graphics g, int x, int y, int tile) {
        g.setColor(getTileColor(tile));
        g.fillRect(x, y, 100, 100);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 100, 100);
        if (tile != 0) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            g.drawString(Integer.toString(tile), x + 35, y + 65);
        }
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 400);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int tile = board[i][j];
                drawTile(g, j * 100, i * 100, tile);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBoard(g);
    }
    
   
    private void moveDown() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = SIZE-2; x >= 0; x--) {
                if (board[x][y] != 0) {
                    int px = x;
                    while (px < SIZE-1 && board[px + 1][y] == 0) {
                        board[px + 1][y] = board[px][y];
                        board[px][y] = 0;
                        px++;
                    }
                }
            }
        }
    }

    private void mergeDown() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = SIZE-2; x >= 0; x--) {
                if (board[x][y] != 0 && board[x + 1][y] == board[x][y]) {
                    board[x + 1][y] *= 2;
                    board[x][y] = 0;
                }
            }
        }
    }

    private void moveUp() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 1; x < SIZE; x++) {
                if (board[x][y] != 0) {
                    int px = x;
                    while (px > 0 && board[px - 1][y] == 0) {
                        board[px - 1][y] = board[px][y];
                        board[px][y] = 0;
                        px--;
                    }
                }
            }
        }
    }

    private void mergeUp() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 1; x < SIZE; x++) {
                if (board[x][y] != 0 && board[x - 1][y] == board[x][y]) {
                    board[x - 1][y] *= 2;
                    board[x][y] = 0;
                }
            }
        }
    }

    private void moveLeft() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 1; y < SIZE; y++) {
                if (board[x][y] != 0) {
                    int py = y;
                    while (py > 0 && board[x][py - 1] == 0) {
                        board[x][py - 1] = board[x][py];
                        board[x][py] = 0;
                        py--;
                    }
                }
            }
        }
    }

    private void mergeLeft() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 1; y < SIZE; y++) {
                if (board[x][y] != 0 && board[x][y - 1] == board[x][y]) {
                    board[x][y - 1] *= 2;
                    board[x][y] = 0;
                }
            }
        }
    }

    private void moveRight(){
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
    private void mergeRight(){
        for(int x = 0; x < SIZE; x++){
            for(int y = SIZE-2; y >= 0; y--){
                if(board[x][y] != 0 && board[x][y] == board[x][y+1]){
                    board[x][y+1] *= 2;
                    board[x][y] = 0;
                }
            }
        }
    }
  
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
        // TODO Auto-generated method stub
        switch (e.getKeyCode()){
        case KeyEvent.VK_DOWN:
            boardBefore = Arrays.copyOf(board, board.length);
            moveDown();
            mergeDown();
            moveDown();
            addNewTile();
            break;
         case KeyEvent.VK_UP:
            boardBefore = Arrays.copyOf(board, board.length);
            moveUp();
            mergeUp();
            moveUp();
            addNewTile();
            break;
        case KeyEvent.VK_LEFT:
            boardBefore = Arrays.copyOf(board, board.length);
            moveLeft();
            mergeLeft();
            moveLeft();
            addNewTile();
            break;
        case KeyEvent.VK_RIGHT:
            boardBefore = Arrays.copyOf(board, board.length);
            moveRight();
            mergeRight();
            moveRight();
            addNewTile();
            break;
        case KeyEvent.VK_Z:
            board = Arrays.copyOf(boardBefore, boardBefore.length);
            System.out.println(" 撤回");
            break;
        }
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(boardBefore[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    private Color getTileColor(int tile) {
        switch (tile) {
        case 2:
            return new Color(238, 228, 218); // light yellow
        case 4:
            return new Color(237, 224, 200); // yellow
        case 8:
            return new Color(242, 177, 121); // orange
        case 16:
            return new Color(245, 149, 99); // light orange
        case 32:
            return new Color(246, 124, 95); // red
        case 64:
            return new Color(246, 94, 59); // light red
        case 128:
            return new Color(237, 206, 114); // light green
        case 256:
            return new Color(237, 204, 97); // green
        case 512:
            return new Color(237, 201, 80); // light blue
        case 1024:
            return new Color(237, 197, 63); // blue
        case 2048:
            return new Color(237, 194, 46); // yellow-green
        default:
            return new Color(204, 192, 179); // gray
        }
    }
    
    public static void main(String[] args) {
        new Final();
    }
}