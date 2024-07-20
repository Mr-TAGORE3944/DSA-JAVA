package Sorting;

import java.util.Arrays;

public class insertion_sort {
        static void swap(int[] arr , int i , int j){
        // arr[i] = arr[i] + arr[j];
        // arr[j] = arr[i] - arr[j];
        // arr[i] = arr[i] - arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }




    static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                swap(arr , j , j-1);
                j--;
            }
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {2,4,1,2,56,87,9,4,3,2,6,78,9,93,2,4,90};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
