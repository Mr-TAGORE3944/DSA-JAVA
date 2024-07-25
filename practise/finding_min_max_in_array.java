package practise;

import java.util.Arrays;
import java.util.Stack;

public class finding_min_max_in_array {

    static void find_next_min(int[] a){
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        st.push(a[n-1]);
        int[] res = new int[n];
        res[n-1] = -1;
        for(int i = n-2 ; i>= 0 ; i--){
            while (st.size() > 0 && st.peek() > a[i]) {
                st.pop();
            }
            if(st.size() == 0) res[i] = -1;
            else res[i] = st.peek();

            st.push(a[i]);
        }


        System.out.println(Arrays.toString(res));
    }
    static void find_next_max(int[] a){
        int n = a.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(a[n-1]);
        res[n-1] = -1;
        for(int i = n-2 ; i>= 0 ; i--){
            while (st.size() > 0 && st.peek() < a[i]) {
                st.pop();
            }
            if(st.size() == 0 ) res[i] = -1;
            else res[i] = st.peek();
            st.push(a[i]);
        }

        System.out.println(Arrays.toString(res));
    }


    public static void main(String[] args) {


        int[] arr = {1,5,3,2,1,6,3,4};
        find_next_min(arr);
        find_next_max(arr);
        
    }
}
