package practise;
import java.util.*;
public class TreeClosestSum {


    public static List<List<Integer>> ThreeSumClosest(int[] nums , int target){
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];

        for(int i = 0 ; i < n - 2; i++){
            // skip duplicates 
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1 ;
            int right = n - 1;

            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];

                if(Math.abs(current - target) < Math.abs(close - target)){
                    close = current;
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                }

                else if (target > current) {
                    left++;
                }else{
                    right--;
                }
            }
        }

        return result;
    }

     public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with the first possible sum
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Check if the current sum is closer to the target than the closest sum found so far
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;  // Move left pointer to increase the sum
                } else if (currentSum > target) {
                    right--;  // Move right pointer to decrease the sum
                } else {
                    return currentSum;  // Found a sum exactly equal to the target
                }
            }
        }
        
        return closestSum;  // Return the closest sum found
    }


    public static int Ans(int[] arr , int target){
        int n = arr.length;
        Arrays.sort(arr);
        int close = arr[0] + arr[1] + arr[2];

        for(int i = 0 ; i < n - 2 ; i++){
            // skip the duplicates from the given array
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int current = arr[i] + arr[left] + arr[right];

                if(Math.abs(current - target) < Math.abs(close - target)){
                    close = current;
                }
                if (target > current){
                    left++;
                }else if(current > target){
                    right--;
                }else{
                    return current;
                }
            }
        }

        return close;
    }
    


    public static void main(String[] args) {
        int[] nums = {-1 , 2 , 1 , -4};

        System.out.println(ThreeSumClosest(nums , 1));
        System.out.println(threeSumClosest(nums , 1));
        System.out.println(Ans(nums, 1));
    }
}
