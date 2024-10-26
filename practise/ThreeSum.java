package practise;
import java.util.*;
public class ThreeSum {

    public static List<List<Integer>> Treesum(int[] arr){
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0  ; i < n -2 ; i++){
            //skip duplicates form given array.
            if( i > 0 && arr[i] == arr[i-1]){
                continue;
            }

            int left = i +1 ;
            int right =  n-1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    result.add(Arrays.asList(arr[i] , arr[left] , arr[right]));
                    left++;
                    right--;

                    while( left < right && arr[left] == arr[left-1]) left++;
                    while(left < right && arr[right] == arr[right+1]) right--;


                }
                else if( sum < 0){
                    left++;
                }else{
                    right--;
                }
            }

            

        }

        return result;

    }






    public static List<List<Integer>> Treesum2(int[] nums){
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < n -2 ; i++){
            /// skip duplicates present in nums array
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int left = i +1;
            int right = n-1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                if( sum == 0){
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;

                    // skip the duplicates which a head the pointers 
                    while (left < right && nums[left] == nums[left-1]) {
                        continue;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        continue;
                    }
                }else if (sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return result;
    }
    


    public static void main(String[] args) {
        int[] arr = {-1 , 0 , 1 , 2 , -1, -4};

        System.out.println(Treesum2(arr));
        System.out.println(Treesum(arr));

    }
}
