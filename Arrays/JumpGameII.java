public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the farthest we can reach is the last index or beyond, break
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};

        System.out.println(solution.jump(nums1)); // Output: 2
        System.out.println(solution.jump(nums2)); // Output: 2
    }
}
