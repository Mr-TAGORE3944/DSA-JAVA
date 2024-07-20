import java.util.Scanner;

public class equal_partition_of_array {
        static void prefixsum(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = arr[i-1] + arr[i];
        }
    }

    static boolean equlPartion(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while (i <= j) {
            if(arr[i] == arr[j] - arr[i]){
                return true;
            }
            i++;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        prefixsum(arr);
        // boolean a = equlPartion(arr);
        System.out.println(equlPartion(arr));


    }
}
