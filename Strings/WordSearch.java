public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true; // All characters matched
        }

        // Check boundaries and character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all possible directions (up, down, left, right)
        boolean found = dfs(board, word, i - 1, j, index + 1) || // Up
                dfs(board, word, i + 1, j, index + 1) || // Down
                dfs(board, word, i, j - 1, index + 1) || // Left
                dfs(board, word, i, j + 1, index + 1); // Right

        // Backtrack: unmark the current cell
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println(ws.exist(board1, "ABCCED")); // Output: true
        System.out.println(ws.exist(board1, "SEE")); // Output: true
        System.out.println(ws.exist(board1, "ABCB")); // Output: false
    }
}
