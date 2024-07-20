package problems;

public class L_45_problem_Q1 {

    static int findFirstOccurence(int[] arr , int target){
        int n = arr.length;
        int st = 0, end = n-1;
        int found = -1;
        while ( st <= end) {
            int mid = st + (end - st) / 2;
            if(arr[mid] == target){
                end = mid -1;
                found = mid;
            } else if(arr[mid] > target){
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return found;
    }
        static int lastOccurence(int[] arr , int target){
        int n = arr.length;
        int st = 0, end = n-1;
        int found = -1;
        while ( st <= end) {
            int mid = st + (end - st) / 2;
            if(arr[mid] == target){
                st = mid + 1;
                found = mid;
            } else if(arr[mid] > target){
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return found +1;
    }
    

    public static void main(String[] args) {
        

        int[] arr = {1,1,1,1,12,2,2,2,3,3,3,44,4,2,2,2,5,5,5,8,8,8,9,9,9,4};


        System.out.println(findFirstOccurence(arr, 1));
        System.out.println(lastOccurence(arr, 1));
    }
}
