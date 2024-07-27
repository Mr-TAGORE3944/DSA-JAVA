package queue;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class reverse_q_k_times {
    

    public static void main(String[] args) {
        int k = 3;
        Queue<Integer> q = new LinkedList();
        Stack<Integer> st = new Stack<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        for(int i = 0 ; i < k ; i++){
            st.push(q.poll());
                }
        for(int i = 0 ; i < k ;i++){
            q.add(st.pop());
        }
        for(int i = k ; i < q.size() ; i++){
            q.add(q.poll());
        }
        System.out.println(q);
    }
}
