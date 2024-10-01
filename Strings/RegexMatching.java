public class RegexMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches with empty pattern
        dp[0][0] = true;

        // Deals with patterns like a*, a*b*, a*b*c* that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentCharS = s.charAt(i - 1);
                char currentCharP = p.charAt(j - 1);

                if (currentCharP == '.' || currentCharS == currentCharP) {
                    // If characters match or pattern has '.', inherit the previous state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentCharP == '*') {
                    // Two options:
                    // 1. Assume '*' represents zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2];

                    // 2. Assume '*' represents one or more occurrences of the preceding character
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == currentCharS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegexMatching matcher = new RegexMatching();
        String s = "aab";
        String p = "c*a*b";
        boolean result = matcher.isMatch(s, p);
        System.out.println(result);  // Output: true
    }
}
