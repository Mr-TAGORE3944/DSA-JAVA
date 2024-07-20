package searching;

public class binary_search {


    static boolean binarySearch(int[] arr , int target){
                int n = arr.length;

                int st = 0 ;
        int end = n-1;
                
        while (st <= end) {
                int mid = st + (end-st) / 2;
                    if(arr[mid] == target) return true;
                    else if(arr[mid] < target){
                        st = mid + 1;
                    } else {
                        end = mid -1;
                    }
                }

                return false;
    }
    static boolean recersiveBinarySearch(int[] arr , int st , int end , int target){
        if(st > end) return false;
        int mid = st + (end - st) / 2;
        if(arr[mid] == target){
            return true;
        }

        else if(arr[mid] < target){
          return  recersiveBinarySearch(arr, mid+1, end, target);
        } else {
          return  recersiveBinarySearch(arr, st, mid -1, target);
        }
    }

    public static void main(String[] args) {
        

        int[ ] arr = {2,3,5,6,8,9,0};

        for(int i = 0 ; i  < 12 ; i++){
            System.out.println(  i +" " + binarySearch(arr, i));
            System.out.println(i  + " " + recersiveBinarySearch(arr, 0, arr.length-1, i));
            System.out.println();
        }
    }
}
