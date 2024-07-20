import java.util.Scanner;

public class pt_0_1_Triangle {
    public static void main(String[] args) {
                        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows : ");
        int a = sc.nextInt();

        for(int i = 0 ; i <= a ; i++){
            for(int j = 0 ; j <i; j++){
                if(i % 2 == 0){
                    System.out.print(j % 2);
                    
                } else {
                    System.out.print((j % 2 == 0)? 1 : 0);
                }
                
            }
            System.out.println();
        }
    }
}
