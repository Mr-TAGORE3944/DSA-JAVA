package problems;

import java.util.Arrays;

public class L_44_problem_Q3 {

    static void swap(int[] arr , int i  , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void Sort(int[] arr){
        int count1 = 0;
        int count0 = 0;
        int count2 =  0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0) count0++;
            if(arr[i] == 1) count1++;
            if(arr[i] == 2) count2++;
        }
        int k = 0;
        for(int i = 0 ; i < count0 ; i++){
            arr[k++] = 0;
        }        for(int i = 0 ; i < count1 ; i++){
            arr[k++] = 1;
        }        for(int i = 0 ; i < count2 ; i++){
            arr[k++] = 2;
        }
    }
    

    static void ThreePointerSort(int[] arr){
        int n = arr.length;
        int st = 0 , mid = 0 , end = n-1;
        while (mid < end) {
            if(arr[mid] == 0){
                swap(arr , st , mid);
                mid++;
                st++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, end);
                end--;
            }
        }
    }

    public static void main(String[] args) {
        

        int[] arr = {1,0,0,0 , 2,0,1,1,1,2,2,2,0,0,2,2,1,1,1,0};
        // Sort(arr);
        ThreePointerSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
