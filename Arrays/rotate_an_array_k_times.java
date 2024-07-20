import java.util.Arrays;
import java.util.Scanner;
public class rotate_an_array_k_times {
    
    static void swap(int[] a, int i, int j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
    }

    static void reverse(int[] a ,int  n, int k){
       while (n < k) {
        swap(a, n, k);
        n++;
        k--;
       }
    }



    static void rotate(int[] a  , int k){
        int n = a.length;
        reverse(a , 0 , n-k-1);
        reverse(a,  n-k , n-1);
        reverse(a, 0, n-1);

    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lenght og array : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter the values of array: ");
        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(a));
        System.out.print("Enter the k value : ");
        int k = sc.nextInt();
        k = k % n;
        rotate(a, k);
        System.out.println(Arrays.toString(a));

    }
}
