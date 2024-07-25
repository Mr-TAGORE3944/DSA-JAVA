package stacks;

import java.util.Stack;

public class Min_element_in_Stack {

    public static void getMin(int[] h , int target){
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(st.size() == 0){
                st.push(h[i]);
                helper.push(h[i]);
            } else {
                st.push(h[i]);
                int min = h[i] < helper.peek()? h[i] : helper.peek();
                helper.push(min);
            }
        }

        System.out.println(st + "   " + helper);

    }
    

    public static void main(String[] args) {

        int[] h = {7,8,5,6,3,4};
        getMin(h, 0);
        
    }
}
