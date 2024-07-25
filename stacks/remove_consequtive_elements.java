package stacks;

import java.util.Arrays;
import java.util.Stack;

public class remove_consequtive_elements {

    public static int[] remove(int[] a){
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n; i++){
            if(st.size() == 0 || st.peek() != a[i]) st.push(a[i]);
            else if(st.peek() == a[i]){
                if(i == n-1 || a[i] != a[i+1]) st.pop();
                // if(a[i] == a[i+1]) continue;
            }
        }
        int[] arr = new int[st.size()];
        int j = 0;
        for(int i : st){
            arr[j++] = i;
        }
        return arr;
    }

    

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,3,3,4,5,5,5,5,56,6,6,6,6,7};

        System.out.println(Arrays.toString(remove(arr)));
    }
}
