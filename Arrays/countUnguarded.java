class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int unguardedCells = 0;

        // Mark guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1; // Guard
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1; // Wall
        }

        // Mark cells guarded in all four directions
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];

            // Up
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 1 || grid[i][y] == -1)
                    break;
                if (grid[i][y] == 0)
                    grid[i][y] = 2;
            }

            // Down
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 1 || grid[i][y] == -1)
                    break;
                if (grid[i][y] == 0)
                    grid[i][y] = 2;
            }

            // Left
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 1 || grid[x][j] == -1)
                    break;
                if (grid[x][j] == 0)
                    grid[x][j] = 2;
            }

            // Right
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 1 || grid[x][j] == -1)
                    break;
                if (grid[x][j] == 0)
                    grid[x][j] = 2;
            }
        }

        // Count unguarded cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    unguardedCells++;
            }
        }

        return unguardedCells;
    }
}
