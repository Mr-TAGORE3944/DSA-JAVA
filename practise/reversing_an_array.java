import java.util.Arrays;

public class reversing_an_array {




    public static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums){
        int n = nums.length;
        for(int i = 0 ; i < n/2 ; i++){
            swap(nums, i, n-i-1);
        }
    }
    

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,0,10};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
