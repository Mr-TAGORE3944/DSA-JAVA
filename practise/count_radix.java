package practise;

public class count_radix {

    static void displayArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i] > max)
            max = arr[i];
        }

        return max;
    }

    static void countSort(int[] arr , int place){
        int n = arr.length;


        int[] count = new int[10];

        for(int i = 0 ; i < n ;i++){
            count[(arr[i]/place)  % 10]++;
        }
        int[] output = new int[n];

        for(int i = 1 ; i < count.length ; i++){
            count[i] += count[i-1];
        }

        for(int i = n-1 ; i>= 0 ; i--){
            int idx = count[(arr[i]/place)  % 10]-1;
            output[idx] = arr[i];
            count[(arr[i]  / place)  % 10]--;
        }

        for(int i = 0 ; i < output.length ; i++){
            arr[i] = output[i];
        }

    }

    static void radixSort(int[] arr){
        int n = arr.length;
        int max = findMax(arr);
        for(int place = 1 ; max/place > 0 ; place *= 10 ){
            countSort(arr , place);
        }
    }

    public static void main(String[] args) {
        

        int[] arr = {1,6,3,7,9,1,5,4,7,0,9,2,5,6,8,3,7,0};

        // countSort(arr , );

        radixSort(arr);
        displayArray(arr);
    }
}
