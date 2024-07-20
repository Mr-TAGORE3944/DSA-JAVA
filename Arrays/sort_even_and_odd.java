import java.util.Arrays;
public class sort_even_and_odd {


    
    static void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }




    static void sortArray(int[] arr){
        int i = 0;
        int j= arr.length-1;

        while (i < j) {
            if(arr[i] % 2 == 1 && arr[j] % 2 == 0){
                swap(arr , i , j);
                i++;
                j--;
            }

            if (arr[i]%2 == 0) {
                i++;
                
            }
            if(arr[j]%2 == 1){
                j--;
            }
        }


    }
    


    public static void main(String[] args) {
        int [ ] a = {2,3,4,5,67,8,90,6,4,3,5,6,7,89,6,43,2,3,5,67,78,8,44};
        sortArray(a);
        System.err.println(Arrays.toString(a));

    }
}


