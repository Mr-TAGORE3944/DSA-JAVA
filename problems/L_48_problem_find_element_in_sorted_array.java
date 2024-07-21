package problems;
 class L_48_problem_find_element_in_sorted_array {

    static int findFirstOccurence(int[] a , int target){
        int n = a.length;
        int st = 0, end = n-1;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(a[mid] == target){
                ans = mid;
                end = mid -1;
            } else if( a[mid] < target){
                st = mid  +1;
            } else {
                end = mid -1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {2,2,5,5,5,5,5,6,6,6,6,6,9,9,9,9,9,10};

        int target = 9;

        int idx = findFirstOccurence(arr , target);
        System.out.println(arr[idx] + " " +  idx);
    }
    
}