package problems;

import java.util.Arrays;

public class L_44_problem_Q2 {


    static void NegPos(int[] arr){
        int n = arr.length;

        int pivot = 0 ;
        int st = 0;
        int end = n-1;
        while(st <= end){
            while (pivot > arr[st]) st++;
            while(pivot <= arr[end]) end--;


            if(st < end){
                int temp = arr[st];
                arr[st] = arr[end];
                arr[end] = temp;
                st++;
                end--;
            }

        }
    }

    

    public static void main(String[] args) {
        

        int[] arr = {-20 , -4 , 0 , -3 , -7 , -8 , -9 , -10};

        NegPos(arr);
        System.out.println(Arrays.toString(arr));
    }
}
