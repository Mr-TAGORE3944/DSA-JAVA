package Sorting;

public class count_sort {

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


    static void AdvCountSort(int[] arr){
        int n = arr.length;

        int max = findMax(arr);

        int[] count = new int[max+1];

        for(int i = 0 ; i < arr.length;i++){
            count[arr[i]]++;
        }

        int[] output = new int[n];
        //make prefix sum of count array
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        displayArray(count);
        System.out.println();
        for(int i = n-1 ; i>= 0 ; i--){
            int idx = count[arr[i]]-1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }

        for(int i = 0 ; i < output.length ; i++){
            arr[i] = output[i];
        }
    }



    static void countSort(int[] arr){
        int n = arr.length;
        int max = findMax(arr);

        int[] New = new int[max+1];

        for(int i = 0 ; i < n-1 ;i++){
            New[arr[i]]++;
        }
        int k = 0;
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j < New[i] ; j++){
                arr[k++] = i;
            }
        }


        
    }
    

    public static void main(String[] args) {
        

        int[] arr = {1,4,2,5,7,9,3,54,7,90,5,89,4,45,65};

        // countSort(arr);
        AdvCountSort(arr);
        displayArray(arr);
    }
}
