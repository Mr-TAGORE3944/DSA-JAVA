package practise;

// import trees.minimumdepth;

public class jump_game {


    public static boolean canJump(int[] nums){
        int reachable = 0 ;
        for(int i = 0 ; i < nums.length; i++){
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i +nums[i]);
        }

        return true;
    }


    

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(jump(nums));
        System.out.println(MinJump(nums));
        System.out.println(jump2(nums));
        System.out.println(MinJump2(nums));
    }

    public static boolean jump(int[] nums){
        int reach = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if (i > reach) {
                return false;
            }

            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public static int MinJump(int[] nums){
        if (nums.length <= 1) return 0;

        // int n = nums.length;
        int far = 0;
        int end = 0;
        int jumps = 0;

        for(int i = 0; i < nums.length -1; i++){

            far = Math.max(far, i + nums[i]);

            if (i == end) {
                jumps++;
                far = end;
                
            }
            if (end >= nums.length - 1) {
                break;
            }
        }
        return jumps;
    }

        public static int jump2(int[] nums) {
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

    public static int MinJump2(int[] nums){
        int jumps = 0;
        int far = 0;
        int end = 0;

        for(int i = 0; i < nums.length-1; i++){
            far = Math.max(far , i + nums[i]);

            if (i == end) {
                jumps++;
                end = far;
            }

            if (i >= nums.length-1) {
                break;
            }
        }

        return jumps;
    }

}
