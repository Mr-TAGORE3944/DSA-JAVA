import java.util.*;
public class Next_permutation {

    public static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }

    public static void reverse(int[] nums , int i , int j){
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }



    public static void nextPermutation(int[] nums){
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] < nums[i+1]) {
            i--;
        }

        if ( i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] > nums[i]) {
                j--;
            }

            swap(nums , i , j);
        }

        reverse(nums , i +1 , n - 1);
    }
    


    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        int[] num = {1,3,2};
        Ans(num);
        System.out.println(Arrays.toString(num));
    }

    public static void Ans(int nums[]){
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] < nums[i+1]) {
            i--;
        }

        if (i >= 0 ) {
            int j = n - 1;
            while (j >= 0 && nums[j] > nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }
}
