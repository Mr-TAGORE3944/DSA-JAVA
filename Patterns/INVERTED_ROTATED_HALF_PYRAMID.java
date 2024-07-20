import java.util.Scanner;

public class INVERTED_ROTATED_HALF_PYRAMID {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int a = sc.nextInt();
        System.out.print("Enter number of columns : ");
        int b = sc.nextInt();

        for(int i = 0 ; i < a ; i++){
            for(int j = 0 ; j < b-1-i ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < i+1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
