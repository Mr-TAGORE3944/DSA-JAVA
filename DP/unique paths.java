public class Solution {
    public int uniquePaths(int m, int n) {
        // The number of unique paths is given by C(m+n-2, m-1) or C(m+n-2, n-1)
        return combination(m + n - 2, m - 1);
    }
    
    // Helper function to calculate the binomial coefficient C(n, k)
    private int combination(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return (int) res;
    }
}
