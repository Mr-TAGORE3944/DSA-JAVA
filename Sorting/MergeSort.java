package Sorting;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];  // Corrected to mid + 1 + j
        
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {  // Changed < to <= to maintain stability
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {  // Changed >= to <
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 72, 9, 3, 9, 4, 7, 3, 2, 6, 9, 0, 2, 10};
        mergeSort(arr, 0, arr.length - 1);  // Changed arr.length to arr.length - 1
        System.out.println(Arrays.toString(arr));
    }
}
