package practise;

public class minPathSum {
    

    public static int minPathSumfind(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp =new int[n+1][m+1];

        dp[0][0] = grid[0][0];

        // initialzation 
        for(int i = 1 ; i < n + 1; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j = 1 ; j < m + 1; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }


        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < m ; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n][m];
    }



    public static void main(String[] args) {
        
    }
}
