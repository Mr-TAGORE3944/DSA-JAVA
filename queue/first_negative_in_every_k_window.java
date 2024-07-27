package queue;
import java.util.*;
public class first_negative_in_every_k_window {

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int n, int k)
    {
        long[] res = new long[n-k+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(A[i] < 0) q.add(i);
        }
        
        for(int i = 0 ; i < n-k+1 ; i++){
            if(q.size() > 0 && q.peek() < i) q.remove();
            
            if(q.size() > 0 && q.peek() <= i+k-1) res[i] = A[q.peek()];
            else if(q.size() == 0) res[i] = 0;
            else res[i] =0;
        }
        return res;
    }
    
}
}
