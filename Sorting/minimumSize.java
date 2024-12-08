class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt(); // Maximum number of balls in any bag

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(nums, maxOperations, mid)) {
                right = mid; // Try smaller maximum
            } else {
                left = mid + 1; // Increase maximum
            }
        }

        return left;
    }

    private boolean canDistribute(int[] nums, int maxOperations, int maxBalls) {
        int operations = 0;

        for (int balls : nums) {
            // Calculate required splits for the current bag
            if (balls > maxBalls) {
                operations += (balls - 1) / maxBalls;
                if (operations > maxOperations) {
                    return false; // Exceeds available operations
                }
            }
        }

        return true;
    }
}
