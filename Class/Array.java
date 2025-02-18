package Class;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 10 ele: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }
}
