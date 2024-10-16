import java.util.Scanner;

public class Frequency_array {



    static int[] findNumber(int[] arr){

        int[ ] freq = new int[10000];
        for(int i = 0 ; i < arr.length-1 ; i++){
            freq[arr[i]]++;
        }
        return freq;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] a = {1,5,2,66,7,9,22,3,5,78,1000,8,6,9,53,101,102};
        System.out.println("Enter the number you want: ");
        int k = sc.nextInt();

        int[] freq = findNumber(a);
        if(freq[k] > 0){
            System.err.println("present");
        }else {
            System.err.println("not");
        }


    }
}
