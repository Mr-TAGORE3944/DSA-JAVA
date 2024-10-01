In Java, you can solve the wildcard matching problem using dynamic programming (DP). Wildcard matching allows the use of two special characters:
- `?` matches any single character.
- `*` matches any sequence of characters (including the empty sequence).

Here's a dynamic programming solution for wildcard matching:

```java
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if the first i characters in s match the first j characters in p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty pattern matches empty string
        dp[0][0] = true;

        // Fill first row for cases where pattern starts with *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // If current character in pattern is '?' or matches current character in string
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can match an empty sequence (dp[i][j - 1]) or any sequence (dp[i - 1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        String s = "adceb";
        String p = "*a*b";

        boolean result = wm.isMatch(s, p);
        System.out.println("Match result: " + result);  // Expected output: true
    }
}
```

### Explanation:
1. **DP Table (`dp[i][j]`)**:
   - `dp[i][j]` is `true` if the first `i` characters of `s` match the first `j` characters of `p`.
   - `dp[0][0]` is `true` because an empty pattern matches an empty string.
   - If the pattern starts with `*`, it can match an empty sequence, so we initialize the first row accordingly.

2. **Filling the DP Table**:
   - If the current character in `p` is `?` or matches the current character in `s`, then the result is the same as the result without these characters (`dp[i-1][j-1]`).
   - If the current character in `p` is `*`, it can either:
     - Match no character (`dp[i][j-1]`), or
     - Match one or more characters (`dp[i-1][j]`).

3. **Result**: The final value in `dp[m][n]` tells whether the entire string `s` matches the pattern `p`.

### Time Complexity:
- **O(m * n)** where `m` is the length of the string `s` and `n` is the length of the pattern `p`. The dynamic programming table has `m + 1` rows and `n + 1` columns, and we fill each cell once.

### Example:
For input `s = "adceb"` and `p = "*a*b"`, the result is `true` because the pattern can match the entire string:
- `*` can match any sequence (including `"adce"`),
- `a` matches `a`,
- `*` can match any sequence (including `"e"`),
- `b` matches `b`.