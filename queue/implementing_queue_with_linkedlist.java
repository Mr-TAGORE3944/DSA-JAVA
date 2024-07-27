package queue;

import queue.implementing_queue_with_linkedlist.Node.queueLinkedList;

public class implementing_queue_with_linkedlist {
    

    public static class Node {
        int val;
        Node next = null;
        Node(int val){
            this.val = val;
        }
    public static class  queueLinkedList {
        Node head =null;
        Node tail = null;
        int size = 0;

        public void add(int val){
            Node temp = new Node(val);
            if(size == 0 ) {
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public int pop(){
            if(size == 0){
                System.out.println("Queue is Empty!");
                return -1;
            }

                int x = head.val;
                head = head.next;
            size--;
            return x;
        }

        public int peek(){
            if(size == 0){
                System.out.println("Queue is Empty!");
                return -1;
            }
            return head.val;
        }

        public int size(){
            return size;
        }
        public void display(){
            if(size == 0) {
                System.out.println("Queue is Empty!");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
        
    }
    }

    public static void main(String[] args) {
        queueLinkedList q = new queueLinkedList();
        q.display();
        System.out.println(q.size());
        q.add(1);
        System.out.println("size " + q.size());
        q.add(2);
        q.add(31);
        q.add(41);
        q.add(5);
        q.add(6);
        q.pop();
        
        System.out.println();
        System.out.println(q.size());
        q.display();
        System.out.println();
        System.out.println(q.peek());
    }


}
