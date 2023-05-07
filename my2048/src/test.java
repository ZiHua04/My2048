import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int SIZE = 4;
    private final int TARGET = 2048;
    private int[][] board;
    private JLabel scoreLabel;
    private int score;

    public test() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 32));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        scoreLabel = new JLabel("Score: 0");
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);

        board = new int[SIZE][SIZE];

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    mergeLeft();
                    addNewTile();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    mergeRight();
                    addNewTile();
                    break;
                case KeyEvent.VK_UP:
                    moveUp();
                    mergeUp();
                    addNewTile();
                    break;
                case KeyEvent.VK_DOWN:
                    moveDown();
                    mergeDown();
                    addNewTile();
                    break;
                }
                repaint();
            }
        });

        addNewTile();
        addNewTile();
    }

    private void addNewTile() {
        int x, y;
        do {
            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
        } while (board[x][y] != 0);
        board[x][y] = Math.random() < 0.9 ? 2 : 4;
    }

    private void moveLeft() {
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

    private void mergeLeft() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 1; x < SIZE; x++) {
                if (board[x][y] != 0 && board[x - 1][y] == board[x][y]) {
                    board[x - 1][y] *= 2;
                    score += board[x - 1][y];
                    board[x][y] = 0;
                }
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    private void moveRight() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = SIZE - 2; x >= 0; x--) {
                if (board[x][y] != 0) {
                    int py = y;
                    while (py < SIZE - 1 && board[py + 1][y] == 0) {
                        board[py     + 1][y] = board[py][y];
                        board[py][y] = 0;
                        py++;
                    }
                }
            }
        }
    }

    private void mergeRight() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = SIZE - 2; x >= 0; x--) {
                if (board[x][y] != 0 && board[x + 1][y] == board[x][y]) {
                    board[x + 1][y] *= 2;
                    score += board[x + 1][y];
                    board[x][y] = 0;
                }
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    private void moveUp() {
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

    private void mergeUp() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 1; y < SIZE; y++) {
                if (board[x][y] != 0 && board[x][y - 1] == board[x][y]) {
                    board[x][y - 1] *= 2;
                    score += board[x][y - 1];
                    board[x][y] = 0;
                }
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    private void moveDown() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = SIZE - 2; y >= 0; y--) {
                if (board[x][y] != 0) {
                    int py = y;
                    while (py < SIZE - 1 && board[x][py + 1] == 0) {
                        board[x][py + 1] = board[x][py];
                        board[x][py] = 0;
                        py++;
                    }
                }
            }
        }
    }

    private void mergeDown() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = SIZE - 2; y >= 0; y--) {
                if (board[x][y] != 0 && board[x][y + 1] == board[x][y]) {
                    board[x][y + 1] *= 2;
                    score += board[x][y + 1];
                    board[x][y] = 0;
                }
            }
        }
        scoreLabel.setText("Score: " + score);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                g.setColor(getTileColor(board[x][y]));
                g.fillRect(x * getWidth() / SIZE, y * getHeight() / SIZE, getWidth() / SIZE, getHeight() / SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x * getWidth() / SIZE, y * getHeight() / SIZE, getWidth() / SIZE, getHeight() / SIZE);
                if (board[x][y] != 0) {
                    String s = "" + board[x][y];
                    FontMetrics fm = g.getFontMetrics();
                    int tx = x * getWidth() / SIZE + (getWidth() / SIZE - fm.stringWidth(s)) / 2;
                    int ty = y * getHeight() / SIZE + (getHeight() / SIZE + fm.getAscent()) / 2;
                    g.setColor(Color.WHITE);
                    g.drawString(s, tx, ty);
                }
            }
        }
        if (checkGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.RED);
            String s = "Game Over";
            FontMetrics fm = g.getFontMetrics();
            int tx = (getWidth() - fm.stringWidth(s)) / 2;
            int ty = getHeight() / 2;
            g.drawString(s, tx, ty);
        } else if (checkWin()) {
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.GREEN);
            String s = "You Win!";
            FontMetrics fm = g.getFontMetrics();
            int tx = (getWidth() - fm.stringWidth(s)) / 2;
            int ty = getHeight() / 2;
            g.drawString(s, tx, ty);
        }
    }

    private boolean checkGameOver() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == 0 || (x > 0 && board[x][y] == board[x - 1][y])
                        || (x < SIZE - 1 && board[x][y] == board[x + 1][y])
                        || (y > 0 && board[x][y] == board[x][y - 1])
                        || (y < SIZE - 1 && board[x][y] == board[x][y + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == TARGET) {
                    return true;
                }
            }
        }
        return false;
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
        JFrame frame = new JFrame("2048");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test game2048 = new test();
        frame.getContentPane().add(game2048);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game2048.requestFocus();
    }
}