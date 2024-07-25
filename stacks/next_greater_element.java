package stacks;

import java.util.Arrays;
import java.util.Stack;

public class next_greater_element {

    public static int[] findGreater(int[] a){
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        res[n-1] = -1;
        st.push(a[n-1]);
        for(int i = n-2 ; i >= 0; i--){
            while(st.size()>0 && st.peek() < a[i]){
                st.pop();
            }
            if (st.size() == 0) res[i] = -1;
            else res[i] = st.peek();
            st.push(a[i]);
        }
        // int j =0;
        // for(int i : st){
        //     a[j++] = i;
        // }
        return res;
    }
    

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,1,6,3,4};
        System.out.println(Arrays.toString(findGreater(arr)));
    }
}
