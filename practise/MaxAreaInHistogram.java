package practise;

import java.util.Stack;

public class MaxAreaInHistogram {
    

    public static void maxArea(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        // next left Smaller ;
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();

        for(int i = n-1; i>=0 ; i--){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                nsr[i] = n;
            }else {
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        for(int i = 0  ; i < n ; i++){
            int heigth = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            max = Math.max(max, width * heigth);
        }


        System.out.println(max);
}


public static void main(String[] args) {
    int[] arr = {2,1,5,6,2,3};
    maxArea(arr);
}
}
