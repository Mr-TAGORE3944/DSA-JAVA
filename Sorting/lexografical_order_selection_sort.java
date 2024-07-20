package Sorting;

import java.util.Arrays;

public class lexografical_order_selection_sort {

        static void swap(String[] arr , int i , int j){

            String temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

    }


    static void LexograficalOrder(String[] arr){
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++){
            int min_index = i;
            for(int j = i+1; j < n ;j++){
                if(arr[j].compareTo(arr[min_index]) < 0){

                    min_index = j;
                }
            }

            String temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
    

    public static void main(String[] args) {
        String[] arr = {"pine" , "orange" , "apple" , "watermelon" , "papaya" , "pea"};
    LexograficalOrder(arr);
    System.out.println(Arrays.toString(arr));
    
    }

}
