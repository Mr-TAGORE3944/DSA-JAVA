package practise;

public class first_misssing_positive_number {
    

    public static int firstMissing(int[] nums){
        int n = nums.length;

        // swap them in position 

        for(int i = 0 ; i < n ; i++){
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,0};

        System.out.println(firstMissing(nums));
    }
}
