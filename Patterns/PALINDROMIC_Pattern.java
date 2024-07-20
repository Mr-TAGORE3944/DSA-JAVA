import java.util.Scanner;

public class PALINDROMIC_Pattern {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int a = sc.nextInt();



        for(int i = 0 ; i < a ; i++){
            int k = i;
            for(int j = 0 ; j < a-i-1 ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < i ; j++){
                System.out.print(k--);
            }
            if(i > 0){
                k+=2;
                for(int j = 0 ; j < i-1 ; j++){
                    System.out.print(k++);
                }
            }
            System.out.println();
        }
    }
}
