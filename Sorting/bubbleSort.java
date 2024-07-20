package Sorting;

import java.util.Arrays;

public class bubbleSort {

    static void swap(int[] arr , int i , int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    static void AdvBubbleSort(int[] arr){


        for(int i = 0 ; i < arr.length-1 ; i++){
            boolean flag = false;
            for(int j = 0 ; j < arr.length-i-1 ; j++){

                
                if(arr[j] > arr[j+1]){
                    flag = true;
                    swap(arr , j , j+1);
                }
            }
            if(flag == false){
                return;
            }
        }

        
    }
    


    static void bubblesort(int[] arr){
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j < arr.length-i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr , j , j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        

        int[] arr = {1,4,2,5,2,5,7,8,9};

        bubblesort(arr);

        System.out.println(Arrays.toString(arr));


    }
}
