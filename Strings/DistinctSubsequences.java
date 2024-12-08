public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // dp[i][j] will store the number of distinct subsequences of s[0..i-1] matching
        // t[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialization: An empty string t is a subsequence of any string s (there is
        // exactly 1 subsequence of "")
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, we can either:
                    // 1. Use the current character of s in the subsequence (dp[i-1][j-1])
                    // 2. Or ignore the current character of s (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can't use s[i-1], so we ignore it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is stored in dp[n][m] which gives the number of distinct
        // subsequences of s that equal t
        return dp[n][m];
    }

    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println("Number of distinct subsequences: " + solution.numDistinct(s, t)); // Output: 3
    }
}
