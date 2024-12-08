public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // Edge cases: empty string or starts with '0'
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to be decoded

        dp[1] = s.charAt(0) != '0' ? 1 : 0; // If the first character is not '0', there's one way to decode it

        for (int i = 2; i <= n; i++) {
            // Check for valid single-digit decoding
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check for valid two-digit decoding
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        String s = "226";
        System.out.println("Number of ways to decode: " + solution.numDecodings(s)); // Output: 3
    }
}
