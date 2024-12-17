package problems;

public class L_47_peak_problem {

    static int findPeak(int[] arr) {
        int n = arr.length;
        int st = 0;
        int end = n - 1;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 3;
            if (arr[mid] < arr[mid + 1]) {
                ans = mid + 1;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    static int findPearkELement(int[] a) {
        int n = a.length;
        int st = 0, end = n - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (mid == 0 || a[mid] > a[mid + 1] && mid == n - 1 || a[mid] > a[mid - 1]) {
                return mid;
            } else if (a[mid] < a[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 6, 10, 100, 5, 3, 2, 1, 0 };

        System.out.println(arr[findPeak(arr)]);
        System.out.println(arr[findPearkELement(arr)]);

    }
}
