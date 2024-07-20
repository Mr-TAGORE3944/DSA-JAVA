
import java.util.Arrays;
import java.util.Scanner;

public class prefix_sum_array {


    static void prefixsum(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = arr[i-1] + arr[i];
        }
    }

    static int sumOfQuery(int[] arr , int l , int r ){
        if(l > 0){
            return arr[r] - arr[l-1];
        }
        else {
            return arr[r];
        }
    }






    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of Queries : ");
        int q = sc.nextInt();
        prefixsum(arr);
        System.out.println(Arrays.toString(arr));
        while(q > 0){
            System.out.println("Enter the L and R :");
            int l = sc.nextInt();
            int r = sc.nextInt();
            int sum = sumOfQuery(arr, l, r);
            System.out.println(sum);
            q--;
        }

    }
}
