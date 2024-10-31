package practise;

public class maxSubArray {


    public static int maxSubArrayFind(int[] nums){
        int n = nums.length;
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1 ; i < n ; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    


    public static void main(String[] args) {
        int[] arr = { -1 , -1 , 2 ,1 , 5, -10 , -12};
        System.out.println(maxSubArrayFind(arr));
    }
}
