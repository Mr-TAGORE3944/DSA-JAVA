import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class sort_array_non_decreasing {

    static void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    static int[] sortArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int[] ans = new int[arr.length];
        int k = arr.length - 1;

        while (i <= j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                ans[k--] = arr[i] * arr[i];
                i++;
            } else {
                ans[k--] = arr[j] * arr[j];
                j--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the values of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        int[] ans = sortArray(arr);
        System.out.println(Arrays.toString(ans));
    }
}
