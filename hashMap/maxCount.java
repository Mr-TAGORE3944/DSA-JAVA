import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet for quick lookups of banned numbers
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        // Initialize variables
        int currentSum = 0;
        int count = 0;

        // Iterate over numbers in the range [1, n]
        for (int i = 1; i <= n; i++) {
            // Skip banned numbers
            if (bannedSet.contains(i)) {
                continue;
            }

            // If adding the current number exceeds maxSum, stop
            if (currentSum + i > maxSum) {
                break;
            }

            // Add the number to the sum and increment the count
            currentSum += i;
            count++;
        }

        return count;
    }
}
