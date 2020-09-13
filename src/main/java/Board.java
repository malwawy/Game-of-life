public class Board {
    boolean board[][] = new boolean[9][9];
    char alive = 'x';
    char dead = '-';

    public void createBoard() {
        board[1][0] = true;
        board[1][1] = true;
        board[1][2] = true;
        drawBoard();
    }

    public void drawBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j]) {
                    System.out.print(alive);
                } else {
                    System.out.print(dead);
                }
            }
            System.out.println();
        }
    }

    public void nextCycle() {
        int aliveNumber = 0;
        int deadNumber = 0;
        boolean boardTemp[][] = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                countAliveNeighbours(i, j);
                if (countAliveNeighbours(i, j) < 2) {
                    boardTemp[i][j] = false;
                } else if (countAliveNeighbours(i, j) > 3) {
                    boardTemp[i][j] = false;
                } else if (board[i][j]==false &&countAliveNeighbours(i, j) == 3 ) {
                    boardTemp[i][j] = true;
                }
                else if (board[i][j]&&countAliveNeighbours(i, j) == 2 ) {
                    boardTemp[i][j] = true;
            }
        }
        }
        board = boardTemp;
        System.out.println("next cycle");
        drawBoard();


    }

    public int countAliveNeighbours(int x, int y) {
        int aliveNeighboursNumber = 0;
        if ((x>0) && (y<board.length-1)&& board[x - 1][y + 1]) {
            aliveNeighboursNumber++;
        }
        if ((y<board.length-1)&&board[x][y + 1]) {
            aliveNeighboursNumber++;
        }
        if ((y<board.length-1)&&(x<board.length-1)&&board[x + 1][y + 1]) {
            aliveNeighboursNumber++;
        }
        if ((x<board.length-1)&&board[x + 1][y]) {
            aliveNeighboursNumber++;
        }
        if ((x<board.length-1)&&(y>0) &&board[x + 1][y - 1]) {
            aliveNeighboursNumber++;
        }
        if ((y>0)&&board[x][y - 1]) {
            aliveNeighboursNumber++;
        }
        if ((x>0)&&(y>0)&&board[x - 1][y - 1]) {
            aliveNeighboursNumber++;
        }
        if ((x>0)&&board[x - 1][y]) {
            aliveNeighboursNumber++;
        }
        return aliveNeighboursNumber;


    }
}
