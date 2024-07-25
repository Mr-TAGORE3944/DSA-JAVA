package stacks;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {



    public static int largestRectangleArea(int[] h){
        int n = h.length;
        Stack <Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        //calculating next smaller element 
        st.push(n-1);
        nse[n-1] = n;
        for(int i = n-2 ; i>= 0 ; i--){
            while (st.size() > 0 && h[st.peek()] > h[i]) {
                st.pop();
            }
            if(st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        // empty the given stack
        while (st.size() != 0) {
            st.pop();
        }
        //calculating the previous smaller element 
        st.push(0);
        pse[0] = -1;
        for(int i = 1 ; i <= n -1; i++){
            while (st.size() > 0 && h[st.peek()] > h[i]) {
                st.pop();
            }
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
            int max = -1;
            for(int i = 0 ; i < n ; i++){
                int area = h[i] * (nse[i]  - pse[i]  - 1);
                max = Math.max(max, area);
            }
            return max;
    }
    

    public static void main(String[] args) {
        
        int[] h = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(h));

    }
}
