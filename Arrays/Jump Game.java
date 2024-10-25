public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // If current index is beyond the last reachable index
            }
            reachable = Math.max(reachable, i + nums[i]); // Update the farthest reachable index
        }
        return true; // If we reached here, it means we can reach the last index
    }
    
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        
        System.out.println(jumpGame.canJump(nums1)); // Output: true
        System.out.println(jumpGame.canJump(nums2)); // Output: false
    }
}
