package practise;

import java.util.Arrays;
import java.util.Comparator;

public class activitySelection {

    public static int ActivitySelection(int[] st, int[] end) {
        int n = st.length;
        int[][] arr = new int[n][3];
        // index 0 for the index of elements in array
        // index 1 for the start position of elements
        // index 2 for the end position of elements
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = st[i];
            arr[i][2] = end[i];
        }

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));
        int max = 0;

        int last = arr[0][2];
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > last) {
                max++;
                last = arr[i][2];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 6, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        int max = 0;
        int last = end[0];

        for (int i = 1; i < end.length; i++) {
            if (start[i] > last) {
                max++;
                last = end[i];
            }
        }

        System.out.println(max);
        System.out.println(ActivitySelection(start, end));
    }
}
