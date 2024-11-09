public class gameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through each cell in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                // Apply the rules to determine the next state
                if (board[i][j] == 1) { // Cell is currently live
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // Mark as live-to-dead
                    }
                } else { // Cell is currently dead
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // Mark as dead-to-live
                    }
                }
            }
        }

        // Update the board to the next state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; // Finalize as dead
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; // Finalize as live
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int liveNeighbors = 0;
        int rows = board.length;
        int cols = board[0].length;

        // Check all eight neighbors around the cell
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue; // Skip the cell itself

                int newRow = row + i;
                int newCol = col + j;

                // Check if the neighboring cell is within bounds and is live
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (Math.abs(board[newRow][newCol]) == 1) { // Check if it's live in original state
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }
}
