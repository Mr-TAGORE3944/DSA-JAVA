import java.util.Arrays;

public class Reversing_an_array {

    static void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    static void reverseArray(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            swap(a, i, n - 1 - i);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        reverseArray(a);
        System.out.println(Arrays.toString(a));
    }
}
