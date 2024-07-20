package Sorting;

import java.util.Arrays;

public class zeroes_to_end {
        static void swap(int[] arr , int i , int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }



    static void zeroesToEnd(int[] arr){
        int n = arr.length;

        for(int i = 0 ; i <  n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(arr[j] == 0 && arr[j+1] != 0){
                    swap(arr , j , j+1);
                }
            }
        }
    }
    

    public static void main(String[] args) {
        
        int[] arr = {0,5,0,3,42};

        zeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
