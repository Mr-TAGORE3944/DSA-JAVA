package problems;

public class L_46_problem_Q2 {

    static int findNumber(int[] arr , int target){
        int n = arr.length;
        int st = 0 , end = n-1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < arr[n-1]){
                if(target <= arr[end] && target > arr[mid]){
                    st = mid + 1;
                } else {
                    end = mid -1;
                }
            } else {
                if(target < arr[mid] && target >= arr[st]){
                    end = mid-1;
                } else {
                    st = mid + 1;
                }
            }
        }

        return -1;
    }
    

    public static void main(String[] args) {
        

        int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(arr[findNumber(arr, 4)]);
    }
}
