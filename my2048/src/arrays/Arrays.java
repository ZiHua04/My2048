package arrays;


public class Arrays{
    private int SIZE = 4;
    private int[][] board = new int[SIZE][SIZE];
    private int[][] boardBefore = new int[SIZE][SIZE];
    public void addNewTile()
    {
        int x,y;
        do{
            x = (int)(Math.random()*SIZE);
            y = (int)(Math.random()*SIZE);
        }while(board[x][y] != 0);
        board[x][y] = (Math.random()%2 == 0)?2:4;
    }
    public void ShowArrays()
    {
        System.out.println("现在的数组:");
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void ShowArraysBefore()
    {
        System.out.println("上一个数组:");
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(boardBefore[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void backArrays()
    {
        System.out.println("撤回");
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = boardBefore[i][j];
            }
        }
    }
    private void storeArrays()
    {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                boardBefore[i][j] = board[i][j];
            }
        }
        System.out.println();
    }
    public int[][] getArrays()
    {
        return board;   
    }
    public int[][] getArraysBefore()
    {
        return boardBefore;
    }
    public void moveDown()
    {
        storeArrays();
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
        for (int y = 0; y < SIZE; y++) {
            for (int x = SIZE-2; x >= 0; x--) {
                if (board[x][y] != 0 && board[x + 1][y] == board[x][y]) {
                    board[x + 1][y] *= 2;
                    board[x][y] = 0;
                }
            }
        }
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
    public void moveUp()
    {
        storeArrays();
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
        for (int y = 0; y < SIZE; y++) {
            for (int x = 1; x < SIZE; x++) {
                if (board[x][y] != 0 && board[x - 1][y] == board[x][y]) {
                    board[x - 1][y] *= 2;
                    board[x][y] = 0;
                }
            }
        }
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
    public void moveLeft()
    {
        storeArrays();
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
        for (int x = 0; x < SIZE; x++) {
            for (int y = 1; y < SIZE; y++) {
                if (board[x][y] != 0 && board[x][y - 1] == board[x][y]) {
                    board[x][y - 1] *= 2;
                    board[x][y] = 0;
                }
            }
        }
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
    public void moveRight()
    {  
        storeArrays();
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
        for(int x = 0; x < SIZE; x++){
            for(int y = SIZE-2; y >= 0; y--){
                if(board[x][y] != 0 && board[x][y] == board[x][y+1]){
                    board[x][y+1] *= 2;
                    board[x][y] = 0;
                }
            }
        }
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
}