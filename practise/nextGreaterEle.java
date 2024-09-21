package practise;

import java.util.Stack;

public class nextGreaterEle {
    

    public static void findNGE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }else {
                nge[i] = arr[st.peek()];
            }
            st.push(i);
        }

        for(int i : nge){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        findNGE(arr);
    } 
}
