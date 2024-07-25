package practise;

import java.util.Stack;

public class rectangle_histogram_area {

    static int find_area_rectangle(int[] a){
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        //Calulating the next smallest element in array
        st.push(n-1);
        nse[n-1] = n;
        for(int i = n-2 ; i >= 0 ; i--){
            while ( st.size() > 0 && a[st.peek()] > a[i]) {
                st.pop();
            }
            if(st.size() == 0 ) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        // clearing the stack
        while (st.size() >0) {
            st.pop();
        }

        pse[0] = -1;
        st.push(0);
        for(int i = 1 ; i <= n-1 ; i++){
            while (st.size() > 0 && a[st.peek()] > a[i]) {
                st.pop();
            }
            if(st.size() == 0 ) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        //Calculating the area of histogram
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            int area = a[i] * (nse[i] - pse[i] -1);
            max = Math.max(max, area);
        }

        return max;
    }
    


    public static void main(String[] args) {
        int[] h = {2,1,5,6,2,3};

        System.out.println(find_area_rectangle(h));
    }
}
