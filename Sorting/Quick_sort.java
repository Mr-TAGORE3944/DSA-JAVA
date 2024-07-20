package Sorting;

import java.util.Arrays;

public class Quick_sort {


    static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static int partition(int[] arr , int st , int end){
        int pivot = arr[st];
        int cnt = 0;
        for(int i = st + 1 ; i <= end ; i++) {
            if(arr[i] <= pivot) cnt++;
        }
        int pivotindex = cnt + st;
        swap(arr, st, pivotindex);
        int i = st , j = end;
        while ( i < pivotindex && j > pivotindex) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) {
                j--;
            }
            if( i < pivotindex && j > pivotindex){
                swap(arr, i, j);
                i++;
                j--;
            }
            
        }
        return pivotindex;
    }



    static void QuickSort(int[] arr , int st , int end){
        if( st >= end) return;

        int pvot = partition(arr , st , end);
        QuickSort(arr, st, pvot -1);
        QuickSort(arr , pvot + 1 , end);
    }
    public static void main(String[] args) {
        

        int[] arr = {1,5,2,3,7,8,9,2,3,6,7,0,1,2,5,67,8,0};

        QuickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
