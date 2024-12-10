import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents {
    public static int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, Comparator.comparingInt(e -> e[1]));

        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2]; // Initialize with the value of the first event

        // Fill DP array with max values up to each event
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], events[i][2]);
        }

        int maxSum = 0;

        // Iterate through events to find the maximum sum of two non-overlapping events
        for (int i = 0; i < n; i++) {
            // Binary search for the latest non-overlapping event
            int low = 0, high = i - 1, bestIndex = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][1] < events[i][0]) {
                    bestIndex = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Calculate the maximum sum considering the current event
            int currentSum = events[i][2];
            if (bestIndex != -1) {
                currentSum += dp[bestIndex];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] events = {
                { 1, 3, 4 },
                { 2, 5, 2 },
                { 6, 8, 6 },
                { 1, 4, 5 }
        };
        System.out.println("Maximum sum of two non-overlapping events: " + maxTwoEvents(events));
    }
}
