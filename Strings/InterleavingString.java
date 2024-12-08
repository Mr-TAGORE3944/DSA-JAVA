public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        // If lengths don't add up, return false
        if (n + m != l) {
            return false;
        }

        // Create a DP table
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Initialize dp[0][0] to true (empty string interleaves to form an empty
        // string)
        dp[0][0] = true;

        // Fill the first row (using only characters from s1)
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill the first column (using only characters from s2)
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the rest of the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);

                // If s1's current character matches with s3's current character, carry over the
                // result from dp[i-1][j]
                if (c1 == c3) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

                // If s2's current character matches with s3's current character, carry over the
                // result from dp[i][j-1]
                if (c2 == c3) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        // The result will be stored in dp[n][m]
        return dp[n][m];
    }

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println("Is interleaving: " + solution.isInterleave(s1, s2, s3)); // Output: true
    }
}
