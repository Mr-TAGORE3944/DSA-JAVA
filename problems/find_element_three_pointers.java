package problems;

public class find_element_three_pointers {

    static int findTarget(int[] a, int target) {
        int n = a.length;
        int st = 0, end = n - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < a[n - 1]) {
                if (target <= a[end] && target > a[mid]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < a[mid] && target > a[st]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        System.out.println(findTarget(nums, target));
    }
}
