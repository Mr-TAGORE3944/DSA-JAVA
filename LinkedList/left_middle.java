package LinkedList;

import java.util.Stack;

public class left_middle {

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static int middle_left(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static int right_middle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

    public static void reorderList(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
    }
    fast = head;
    Stack<Node> st = new Stack<>();
    while(slow != null){
        st.push(slow);
        slow = slow.next;
    }
    while(!st.isEmpty()){
        slow = fast.next;
        fast.next = st.pop();
        fast.next.next = slow;
    }

    }



    

    public static void main(String[] args) {

Node a = new Node(1);
 Node b = new Node(2);
 Node c = new Node(31);
 Node d = new Node(1);
 Node e = new Node(10);
a.next = b;
 b.next = c;
c.next = d;
d.next = e;
e.next = null;
            reorderList(a);
            while(a != null){
                System.out.println(a.val);
                a = a.next;
            }
    }
}
