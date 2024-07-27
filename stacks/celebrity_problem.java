package stacks;
import java.util.*;
public class celebrity_problem {


    // Function to find if there is a celebrity in the party or not.
    public static int celebrity(int M[][], int n) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            st.push(i);
        }
        while(st.size()>1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(M[v1][v2] == 0) st.push(v1);
            else if(M[v2][v1] == 0) st.push(v2);
        }
            if(st.size() == 0) return -1;
            int potentail = st.pop();
            for(int i = 0 ; i < n;i++){
                if(M[potentail][i] == 1) return -1;
            }
            for(int j = 0 ; j < n ; j++){
                if(j == potentail) continue;
                if(M[j][potentail] == 0) return -1;
            }
            
            return potentail;
            
        

            
    
}

public static void main(String[] args) {
    celebrity(null, 0);
}
}
