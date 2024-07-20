import java.util.Arrays;

public class sort_zeros_and_ones {
    
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
            if(arr[i] == 1 && arr[j] == 0){
                swap(arr , i , j);
                i++;
                j--;
            }

            if (arr[i] == 0) {
                i++;
                
            }
            if(arr[j] == 1){
                j--;
            }
        }


    }
    


    public static void main(String[] args) {
        int [ ] a = {0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,1,0,0,1};
        sortArray(a);
        System.err.println(Arrays.toString(a));

    }
}
