package problems;

public class L_48_kids_on_race_track {
    static boolean isPossible(int[] a, int kids, int dis) {
        int n = a.length;
        int kidsPlaced = 1;
        int lastKid = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - lastKid >= dis) {
                kidsPlaced++;
                lastKid = a[i];
            }
        }

        return kidsPlaced >= kids;
    }

    static int raceTrack(int[] a, int kids) {

        if (kids > a.length)
            return -1;
        int n = a.length;
        int st = 0, end = (int) 1e9;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(a, kids, mid)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 8, 9 };
        System.out.println(raceTrack(a, 3));
    }
}
