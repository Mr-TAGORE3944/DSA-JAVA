import java.util.*;
public class NUMBER_PYRAMID_pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int a = sc.nextInt();

        for(int i = 0 ; i <=a ; i++){
            for(int j = 0 ; j <= a-i-1 ; j++){
                System.out.print(" ");
            } for(int j = 0 ; j <= i ; j++){
                System.out.print(i+1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}