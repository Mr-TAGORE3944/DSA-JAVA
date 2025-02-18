package Class;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        // dynamic input
        int[] arr = new int[10];
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 10 ele: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            Boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i : arr) {
            System.out.print(" " + i);
        }

        // make the char array and convert to string
        char[] ch = { 'a', 'b', 'c', 'd', 'e' };
        String str = new String(ch);
        System.out.println("\n" + str);
        String s = "happy";
        System.out.println(s);
    }
}
