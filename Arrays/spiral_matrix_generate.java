import java.util.Scanner;

public class spiral_matrix_generate {
    static void printArray(int[][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    static void generateSpiralMatrix(int n ){
        int[][] arr = new int[n][n];
        int toprow = 0;
        int bottomrow = n-1;
        int leftcol = 0;
        int rightcol = n-1;
        int totalNumbers =1;
        while (totalNumbers <= n*n) {
            for(int i = leftcol ; i <= rightcol && totalNumbers <= n*n ; i++){
                arr[toprow][i] = totalNumbers++;
            }
            toprow++;
            for(int i = toprow ; i <= bottomrow && totalNumbers <= n*n ; i++){
                arr[i][rightcol] = totalNumbers++;
            }
            rightcol--;
            for(int i = rightcol ; i >= leftcol && totalNumbers <= n*n ; i--){
                arr[bottomrow][i] = totalNumbers++;
            }
            bottomrow--;
            for(int i = bottomrow ; i >= toprow && totalNumbers <= n*n ; i--){
                arr[i][leftcol] = totalNumbers++;
            }
            leftcol++;
        } 

        printArray(arr);
    }







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        generateSpiralMatrix(n);
    }
}
