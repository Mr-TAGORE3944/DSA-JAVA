/**
 * implementation
 */
public class implementation {
    static int[] tree;

    public static void init(int n ){
        tree = new int[4 * n];
    }

    public static int buildTree(int[] arr , int i , int st , int end){
        if(st == end){
            tree[i] = arr[end];
            return arr[end];
        }
        int n = arr.length;
        int mid = ( st + end) / 2;
        buildTree(arr, 2 * i + 1, st, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
        return tree[i];
    }

    public static int getSum(int i , int si , int sj ,int qi ,int qj ){
        // if they doen't overlap together
        if(qi >= sj  || qj <= si){
            return 0;
        }
        // they are completely overlaping to each other
        else if(qi <= si && qj >= sj){
            return tree[i];
        }else{
            int mid = (si + sj)/2;
            return getSum(2*i+1, si, mid, qi, qj) + getSum(2*i+2, mid+1, sj, qi, qj);
        }
    }
    public static int getSum(int[] arr , int qi , int qj){
        return getSum(0, 0, arr.length - 1, qi, qj);
    }

    public static void update(int[] arr , int idx , int num){
            int diff = num - arr[idx];
            arr[idx] = diff;
            update( 0  ,  0 , arr.length-1 ,  idx ,  diff);
    }

    public static void update(int i, int si, int sj, int idx, int diff) {
        if(idx < si || idx > sj){
            return;
        }
        // System.out.println(diff);
        tree[i] += diff;
        if(si != sj){
            int mid = (si + sj) / 2;
            update(2*i+1, si, mid, idx, diff);
            update(2*i+2, mid+1, sj, idx, diff);
        }
    }






    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7,8};
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n-1);

        for( int i : tree){
            System.out.print(i + " ");
        }
        int h = getSum(arr, 2, 5);
        System.out.println();
        System.out.println(h);

        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
        

    }
}