package Sorting;
import java.util.Collections;
import java.util.ArrayList;
public class bucket_sort {


        static void displayArray(float[] arr){
        for(float i : arr){
            System.out.print(i + " ");
        }
    }


    static void bucketSort(float[] arr){
        int n = arr.length;

        ArrayList<Float>[] bucket = new ArrayList[n]; 

        for(int i = 0 ; i < bucket.length ; i++){
            bucket[i] = new ArrayList<Float>();
        }

        for(int i = 0 ; i < n ; i++){
            int idx = (int)  arr[i]  * n;
            bucket[idx].add(arr[i]); 
        }

        for(int i = 0 ; i < bucket.length ; i++){
            Collections.sort(bucket[i]);
        }

        int idx = 0;
        for(int i = 0 ; i < bucket.length ;i++){
            ArrayList<Float> curr = bucket[i];
            for(int j = 0 ; j < curr.size() ; j++){
                arr[idx++] = curr.get(j);
            }
        }

    }
    

    public static void main(String[] args) {
        

        float[] arr = {0.3f , 0.2f , 0.1f , 0.4f,0.5f};

        bucketSort(arr);
        displayArray(arr);
        
    }
}
