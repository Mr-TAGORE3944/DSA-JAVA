public class frog_jump_recursion {
    
static int bestcase(int[] h ,int n  , int idx){
    if(idx == n-1){
        return 0;
    }
    
    
    int op1 =  Math.abs(h[idx] - h[idx + 1])  +  bestcase(h, n, idx+1);
    if(idx == n-2){
        return op1;
    }
        int op2 =  Math.abs(h[idx] - h[idx + 2])  +  bestcase(h, n, idx+2);
    return Math.min(op1, op2);
}




    public static void main(String[] args) {
        

        int[] arr = {10 , 30 , 40 , 20};
int n = bestcase(arr, arr.length, 0);
System.out.println(n);
    }
}
