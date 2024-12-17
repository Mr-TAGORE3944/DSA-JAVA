package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class interleave_1_to_2_halfs {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        int n = q.size();
        for (int i = 0; i < n / 2; i++) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        for (int i = 0; i < n / 2; i++) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
            q.add(q.remove());
        }
        for (int i = 0; i < n; i++) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        System.out.println(q);
    }
}
