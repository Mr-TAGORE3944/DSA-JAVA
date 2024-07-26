import java.util.Scanner;

public class Search_element_in_row_col_sorted_2array {
    


    static boolean findElement(int[][] a , int target){
        int row = 0 , col = a.length-1;
        while (row < a.length && col >=0) {
            if(a[row][col] == target) 
            {
                System.out.println("found at indexs" + "(" + row + " , " + col + ")");
                return true;
            }
            else if (target < a[row][col]){
                col--;
            } else {
                row++;
            }
        }


        return false;

    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3} 
                    ,{4,5,6} 
                    ,{7,8,9}};
        System.out.println(findElement(a, 7));
    }
}
