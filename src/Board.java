public class Board {

    private char[][] board = new char[3][3];

    public char[][] init() {
        for (char[] row : board) {
            for (char mark : row) {
                mark = ' ';
            }
        }
        return board;
    }

    public void print() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.println("| " + row[0] + " | " + row[1] + " | " + row[2] + " | ");
            System.out.println("-------------");
        }
    }

    public boolean isFull() {
        for (char[] row : board) {
            for (char mark : row) {
                if (mark == ' ') return false;
            }
        }
        return true;
    }

    public boolean checkMove(int x, int y, char mark) {
        if (mark == 'X') {
            x--; y--;
        }
        if (x > 3 || y > 3) return false;
        if (board[x][y] != 'X' && board[x][y] != 'O') return true;
        return false;
    }

    public boolean checkWinner(char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    public void move(int x, int y, char mark) {
        if (mark == 'X') {
            x--; y--;
        }
        board[x][y] = mark;
    }
}
