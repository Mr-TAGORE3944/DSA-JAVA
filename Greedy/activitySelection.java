package practise.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class activitySelection {

    public static void ActivitySel(int[] st, int[] end) {

        int[][] arr = new int[st.length][3];
        int max = 0;

        for (int i = 0; i < st.length; i++) {
            arr[i][0] = i;
            arr[i][1] = st[i];
            arr[i][2] = end[i];
        }

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));

        int last = arr[0][2];
        for (int i = 1; i < st.length; i++) {
            if (arr[i][1] > last) {
                max = max + 1;
                last = arr[i][2];
            }
        }

        System.out.println(max);

    }

    public static void main(String[] args) {
        int[] st = { 1, 3, 6, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        int max = 0;
        // end array should be sorted in order

        int last = end[0];
        for (int i = 1; i < end.length; i++) {
            if (st[i] >= last) {
                max = max + 1;
                last = end[i];
            }
        }

        System.out.println(max);
        ActivitySel(st, end);
    }
}
