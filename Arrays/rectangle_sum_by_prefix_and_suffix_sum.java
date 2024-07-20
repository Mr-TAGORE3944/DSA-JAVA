
import java.util.Scanner;
public class rectangle_sum_by_prefix_and_suffix_sum {
    static int findSum(int[][] arr , int l1 , int r1 , int l2 , int r2 ){
        int sum = 0 ;
         int up = 0 ;
          int left = 0 ;
          int leftup = 0;
         sum = arr[l2][r2];
        if(l1 > 0){
             up = arr[l1-1][r2];
        }
        if(r1 > 0){

            left = arr[l2][r1-1];
        }
        if(l1 > 0 && r1>0){

            leftup = arr[l1-1][r1-1];
        }


         return sum - up - left + leftup;

    }

    static void findPrefixAndSuffixSum(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;

        for(int i = 0 ; i < r ; i++){
            for(int j = 1 ; j < c ; j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        for(int i = 1 ; i < c ; i++){
            for( int j = 0 ; j < r ; j++){
                arr[i][j] += arr[i-1][j] ;
            }
        }
    }
 









    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rectangle size : ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Enter the elements: ");
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the L1 R1 L2 R2 : ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        findPrefixAndSuffixSum(arr);

        System.out.println(findSum(arr , l1 , r1 , l2 , r2));

    }
}
