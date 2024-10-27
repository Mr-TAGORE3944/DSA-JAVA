import java.util.Arrays;

public class rotate_an_image {



    public static void rotate(int[][] matrix){
        int n = matrix.length;

        // transpose the given matrix 
        for(int i = 0; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the matrix 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n /2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
    

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix);

        for(int[] num : matrix){
            System.out.println(Arrays.toString(num));
        }
    }
}
