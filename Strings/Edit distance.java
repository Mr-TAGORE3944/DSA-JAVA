
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] represents the edit distance between word1[0...i-1] and
        // word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // If word1 is empty, the cost is adding all characters of word2
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // If word2 is empty, the cost is deleting all characters of word1
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If characters match, no operation is needed, take the value from dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Otherwise, consider the minimum of three possible operations:
                    // 1. Insert (dp[i][j-1])
                    // 2. Delete (dp[i-1][j])
                    // 3. Replace (dp[i-1][j-1])
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // Deletion
                            Math.min(dp[i][j - 1], // Insertion
                                    dp[i - 1][j - 1])); // Replacement
                }
            }
        }

        // The final answer is in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "kitten";
        String word2 = "sitting";

        int result = ed.minDistance(word1, word2);
        System.out.println("Edit Distance: " + result); // Output: 3
    }
}

// ### Explanation:

// 1. **DP Table (`dp[i][j]`)**:
// - `dp[i][j]` represents the minimum number of operations required to convert
// the first `i` characters of `word1` to the first `j` characters of `word2`.
// - **Base cases**:
// - If `word1` is empty, the cost is the number of insertions required to match
// `word2` (`dp[0][j] = j`).
// - If `word2` is empty, the cost is the number of deletions required to match
// `word1` (`dp[i][0] = i`).

// 2. **Filling the DP Table**:
// - If `word1[i-1] == word2[j-1]`, no operation is needed, so `dp[i][j] =
// dp[i-1][j-1]`.
// - Otherwise, we consider the three possible operations:
// - **Insert** a character in `word1`: This reduces the problem to `dp[i][j-1]
// + 1`.
// - **Delete** a character from `word1`: This reduces the problem to
// `dp[i-1][j] + 1`.
// - **Replace** a character in `word1`: This reduces the problem to
// `dp[i-1][j-1] + 1`.

// 3. **Result**: The final value, `dp[m][n]`, contains the minimum number of
// operations required to convert `word1` into `word2`.

// ### Example:

// For `word1 = "kitten"` and `word2 = "sitting"`, the edit distance is
// calculated as follows:
// 1. Replace `'k'` with `'s'`: `"kitten" -> "sitten"`
// 2. Replace `'e'` with `'i'`: `"sitten" -> "sittin"`
// 3. Insert `'g'`: `"sittin" -> "sitting"`

// The total number of operations is 3.

// ### Time Complexity:
// - **O(m * n)** where `m` is the length of `word1` and `n` is the length of
// `word2`. We fill a 2D table of size `m x n`, and each cell takes constant
// time to compute.

// ### Space Complexity:
// - **O(m * n)** because we are using a 2D array to store the results of
// subproblems.

// ### Space Optimization:

// If you want to reduce the space complexity to **O(n)** (where `n` is the
// length of `word2`), you can use a 1D array since the current state in `dp`
// depends only on the current and previous rows:

// ```java
// public class EditDistance {
// public int minDistance(String word1, String word2) {
// int m = word1.length();
// int n = word2.length();

// // Use a 1D array to represent the previous row in the dp table
// int[] dp = new int[n + 1];

// // Initialize the base case for when word1 is empty
// for (int j = 0; j <= n; j++) {
// dp[j] = j;
// }

// // Iterate through the characters of word1
// for (int i = 1; i <= m; i++) {
// int prev = dp[0]; // Store the previous diagonal element
// dp[0] = i; // Initialize the first element in the row for deletions

// for (int j = 1; j <= n; j++) {
// int temp = dp[j]; // Save the current value before updating

// if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// dp[j] = prev; // If characters match, no change needed
// } else {
// dp[j] = 1 + Math.min(dp[j - 1], // Insertion
// Math.min(dp[j], // Deletion
// prev)); // Replacement
// }

// prev = temp; // Update the previous diagonal element
// }
// }

// return dp[n];
// }
// }
// ```

// This optimized version keeps only the current and previous rows in memory,
// reducing the space complexity to **O(n)**.