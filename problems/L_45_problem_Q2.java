package problems;

public class L_45_problem_Q2 {

    static int roundOff(int x) {
        int st = 0;
        int end = x;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int val = mid * mid;
            if (val == x) {
                return mid;
            } else if (val < x) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(roundOff(24));

    }
}
