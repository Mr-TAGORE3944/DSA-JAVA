/**
 * implementation
 */
public class implementation {
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildTree(int[] arr, int i, int st, int end) {
        if (st == end) {
            tree[i] = arr[end];
            return arr[end];
        }
        int n = arr.length;
        int mid = (st + end) / 2;
        buildTree(arr, 2 * i + 1, st, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static int getSum(int i, int si, int sj, int qi, int qj) {
        // if they doen't overlap together
        if (qi >= sj || qj <= si) {
            return 0;
        }
        // they are completely overlaping to each other
        else if (qi <= si && qj >= sj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            return getSum(2 * i + 1, si, mid, qi, qj) + getSum(2 * i + 2, mid + 1, sj, qi, qj);
        }
    }

    public static int getSum(int[] arr, int qi, int qj) {
        return getSum(0, 0, arr.length - 1, qi, qj);
    }

    public static void update(int[] arr, int idx, int num) {
        int diff = num - arr[idx];
        arr[idx] = diff;
        update(0, 0, arr.length - 1, idx, diff);
    }

    public static void update(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) {
            return;
        }
        // System.out.println(diff);
        tree[i] += diff;
        // for leaf nodes
        if (si != sj) {
            int mid = (si + sj) / 2;
            update(2 * i + 1, si, mid, idx, diff);
            update(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    static int tree2[];

    public static void init2(int n) {
        tree2 = new int[4 * n];
    }

    public static void buildMaxST(int[] arr, int i, int si, int sj) {
        if (si == sj) {
            tree2[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildMaxST(arr, 2 * i + 1, si, mid);
        buildMaxST(arr, 2 * i + 2, mid + 1, sj);
        tree2[i] = Math.max(tree2[2 * i + 1], tree2[2 * i + 2]);
        return;
    }

    public static int getMax(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getMax(0, 0, n - 1, qi, qj);
    }

    public static int getMax(int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si)
            return Integer.MIN_VALUE;
        else if (si >= qi && sj <= qj)
            return tree2[i];
        else {
            int mid = (si + sj) / 2;
            int leftAns = getMax(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMax(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n - 1);

        for (int i : tree) {
            System.out.print(i + " ");
        }
        int h = getSum(arr, 2, 5);
        System.out.println();
        System.out.println(h);

        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));

        init2(n);
        buildMaxST(arr, 0, 0, n - 1);
        for (int i : tree2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(getMax(arr, 2, 5));

    }
}