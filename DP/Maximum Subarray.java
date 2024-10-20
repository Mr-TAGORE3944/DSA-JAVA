class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize currentSum and maxSum with the first element of the array
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Iterate over the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum to hold the largest sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum subarray sum
        return maxSum;
    }
}
