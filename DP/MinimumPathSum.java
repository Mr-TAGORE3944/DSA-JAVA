public class MinimumPathSum {

}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the dp table with the same size as the grid
        int[][] dp = new int[m][n];

        // Base case: start at the top-left corner
        dp[0][0] = grid[0][0];

        // Fill the first row (only can come from the left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column (only can come from above)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Current cell is the minimum path sum from either above or left
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // The answer is in the bottom-right corner
        return dp[m - 1][n - 1];
    }
}
