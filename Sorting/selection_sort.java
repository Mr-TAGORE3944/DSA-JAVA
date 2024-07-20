package Sorting;

import java.util.Arrays;

public class selection_sort {

        static void swap(int[] arr , int i , int j){
        // arr[i] = arr[i] + arr[j];
        // arr[j] = arr[i] - arr[j];
        // arr[i] = arr[i] - arr[j];

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        }


    static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++){
            int min_index = i;
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] < arr[min_index])
                min_index = j;
            }

            swap(arr , i , min_index);
        }
    }
    public static void main(String[] args) {
        


        int[] arr = {1,5,2,7,9,3,2,5,4,4,2,5,9,7};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
