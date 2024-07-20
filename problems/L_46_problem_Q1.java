package problems;

public class L_46_problem_Q1 {

    static int findMin(int[] arr){
        int n = arr.length;
        int st = 0 , end = n-1;
        int ans = -1;

        while ( st <= end) {
            int mid = st + (end - st) / 2;
            // if(arr[mid] >= arr[mid +1] && arr[mid] <= arr[mid-1]){
            //     return mid;
            // } else 
            if(arr[mid] > arr[n-1]){
                st = mid + 1;
            } else {
            end = mid -1;
            ans = mid;
            }
        }

        return ans;
    }
    

    public static void main(String[] args) {
        

        int[] arr = {5,6,7,8,9,1,2,3,4};

        System.out.println(arr[findMin(arr)]);
    }
}
