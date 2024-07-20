import java.util.Scanner;

public class FLOYD_Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int a = sc.nextInt();
        int k =1;
        for(int i = 1 ; i <= a ; i++){
            for(int j = 1 ; j <= i ; j++ , k++){
                System.out.print(k);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
