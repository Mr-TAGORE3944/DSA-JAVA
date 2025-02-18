import java.util.Arrays;

// import backtracking.maxKnights;

public class ImplementationSegmentTree {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildSegementTree(int arr[], int st, int end, int i) {
        if (st == end) {
            tree[i] = arr[end];
            return;
        }

        int mid = (st + end) / 2;
        // building the left Segement tree for given programe
        buildSegementTree(arr, st, mid, 2 * i + 1);
        // now building the right Segment tree for given programe
        buildSegementTree(arr, mid + 1, end, 2 * i + 2);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

    }

    public static void buildSegementTree2(int arr[], int i, int st, int end) {
        if (st == end) {
            tree[i] = arr[end];
            return;
        }

        int mid = (st + end) / 2;

        // left Segment tree building
        buildSegementTree2(arr, 2 * i + 1, st, mid);
        // Right Segment tree building
        buildSegementTree2(arr, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

    }

    public static void MaxSegement(int arr[], int i, int st, int end) {

        if (st == end) {
            tree[i] = arr[end];
            return;
        }

        int mid = (st + end) / 2;

        MaxSegement(arr, 2 * i + 1, st, mid);

        MaxSegement(arr, 2 * i + 2, mid + 1, end);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // checking for non-overlaping in given array.
        if (qj < si || qi > sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            // partial overlaping in the given range
            int mid = (si + sj) / 2;
            return getSumUtil(2 * i + 1, si, mid, qi, qj) + getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void update(int arr[], int idx, int val) {
        int n = arr.length;
        int diff = arr[idx] - val;
        updateUtil(0, 0, n - 1, idx, diff);
    }

    public static void updateUtil(int i, int st, int end, int idx, int diff) {

        if (idx > end || idx < st) {
            return;
        }

        tree[idx] += diff;

        if (st != end) {

            int mid = (st + end) / 2;

            updateUtil(2 * i + 1, st, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, end, idx, diff);
        }
    }

    public static int[] tree2 = new int[4 * 5];

    public static void maxSeg(int arr[], int i, int st, int end) {
        if (st == end) {
            tree2[i] = arr[end];
            return;
        }
        int mid = (st + end) / 2;
        maxSeg(arr, 2 * i + 1, st, mid);
        maxSeg(arr, 2 * i + 2, mid + 1, end);
        tree2[i] = Math.max(tree2[2 * i + 1], tree2[2 * i + 2]);
    }

    public static int getMax(int arr[], int st, int end) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, st, end);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (qi <= si && sj <= qj) {
            return tree2[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);

            return Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        init(arr.length);
        buildSegementTree2(arr, 0, 0, arr.length - 1);
        // MaxSegement(arr, 0, 0, arr.length - 1);

        System.out.println(Arrays.toString(tree));
        System.out.println(getSum(arr, 2, 5));

        int arr1[] = { 1, 2, 3, 4, 5 };
        maxSeg(arr1, 0, 0, arr1.length - 1);
        System.out.println(getMax(arr1, 0, arr1.length - 2));
    }
}
