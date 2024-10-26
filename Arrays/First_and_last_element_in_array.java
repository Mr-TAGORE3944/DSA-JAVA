public class First_and_last_element_in_array {




    public static int firstPos(int[] nums , int target){
        int left = 0 , right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                pos = mid;
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return pos;
    }


    public static int lastPos(int[] nums ,int target){
        int left = 0 , right = nums.length;
        int pos = -1;

        while (left <= right) {
            
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                pos = mid;
                left = mid + 1;
            }else if (nums[left] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return pos;
    }
    


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1,1,1,1,11,2,2,22,2,2222,2,22,26,7,8,9,10};
        System.out.println(arr[firstPos(arr, 2)]);
        System.out.println(arr[lastPos(arr, 2)]);
        System.out.println(firstPos(arr, 2));
        System.out.println(lastPos(arr, 2));
    }
}
