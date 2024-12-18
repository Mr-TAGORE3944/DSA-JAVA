package backtracking;

public class nQueens {

    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // row check
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q')
                return false;
        }
        // check col
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        int i = row;
        int j = col;
        // check north east
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        // check south east
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        // check north west
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        // check south east
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void nqueen(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nqueen(board, row + 1);
                board[row][i] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        nqueen(board, 0);
    }
}
