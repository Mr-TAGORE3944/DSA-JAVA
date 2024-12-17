import java.util.*;

public class practise {

    public static int[] Tree;

    public static void init(int n) {
        Tree = new int[2 * n - 1];
    }

    public static int buildST(int[] arr, int i, int start, int end) {
        if (start == end) {
            Tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;

        int left = buildST(arr, 2 * i + 1, start, mid);
        int right = buildST(arr, 2 * i + 2, mid + 1, end);

        Tree[i] = left + right;

        return Tree[i];
    }

    public static int getSum(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || sj <= qi) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return Tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getSum(i * 2 + 1, si, mid, qi, qj);
            int right = getSum(i * 2 + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int[] arr, int qi, int qj) {
        return getSum(0, 0, arr.length - 1, qi, qj);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        init(arr.length);

        buildST(arr, 0, 0, arr.length - 1);
        System.out.println(Arrays.toString(Tree));
        // System.out.println(getSum(0, 0, 0, 0, 0));
        System.out.println(getSum(arr, 2, 5));
    }
}
