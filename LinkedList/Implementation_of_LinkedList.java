
package LinkedList;
public class Implementation_of_LinkedList {


    
        public static class Node{
            int data;
            Node next;
            
            Node(int data){
                this.data = data;
            }
        }
        
        public static class Linkedlist {
            Node head = null;
            Node tail = null;
            int size = 0;


        void display(){
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

        }

        void insertAtEnd(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;
            } else{
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void insertAtHead(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;

            } else {
                temp.next = head;
                head = temp;
            }

            size++;
        }

        // void insertAt(int idx , int val){
        //     Node t = new Node(val);
        //     Node temp = head;
        //     for(int i = 1 ; i <= idx-1; i++){
        //         temp.next = temp;
        //     }
        //     t.next = temp.next;
        //     temp.next = t;
        // }

        int getElement(int idx){
            Node temp = head;
            for(int i = 1 ; i <= idx;i++){
                temp = temp.next;
            }
            return temp.data;
        }

        void deleteElement(int idx){
            Node temp = head;

            if(idx == 0){
                head = temp.next;
                size--;
                return;
            } 
            for(int i =  1; i <= idx-1 ; i++){
                temp = temp.next;
            }
            if(idx == size-1){
                tail = temp;
                return;
            }

            temp.next = temp.next.next;
            size--;

        }

        int getElementFromEnd(int nth){
            Node temp = head;
            int count = 0;
            while(temp != null) {
                count++;
                temp= temp.next;
            }
            Node t = head;
            for(int i = 1 ;  i < count - nth + 1 ; i++){
                t = t.next;
            }
            return t.data;
        }

        Node getNodeFromLast(int nth){
            Node slow = head;
            Node fast = head;
            for(int i  = 1; i <= nth ; i++){
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        void deleteNodeFromLast(int nth){
            if(nth == 0    || nth < 0){
                System.out.println("worng");
                return;
            }
            Node slow = head;
            Node fast = head;
            for(int i = 1 ; i <= nth ; i++){
                fast = fast.next;
            }
            if(fast == null){
                head = head.next;
                return;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
    
        
    }

    // public static void display(Node head){
    //     while(head != null){
    //         System.out.println(head.data);
    //         head = head.next; 
    //     }
    // }

    // public static void main(String[] args) {
    //     // Node a = new Node(1);
    //     // Node b = new Node(2);
    //     // Node c = new Node(31);
    //     // Node d = new Node(1);
    //     // a.next = b;
    //     // b.next = c;
    //     // c.next = d;

    //     Linkedlist ll = new Linkedlist();
    //     ll.insertAtEnd(11);
    //     ll.insertAtEnd(12);
    //     ll.insertAtEnd(13);
    //     ll.insertAtEnd(14);
    //     ll.insertAtEnd(15);
    //     ll.insertAtEnd(16);

    //     ll.insertAtHead(100);

    //     System.out.println(ll.getElement(4));

    //     ll.deleteElement(4);
    //     ll.deleteElement(0);
    //     ll.deleteElement(ll.size-1);
    //     System.out.println(ll.head.data);
    //     System.out.println(ll.tail.data);
    //     System.out.println("size : " + ll.size);

    //     // ll.insertAt(2 , 200);
    //     ll.display();
    //     System.out.println();
    //     System.out.println(ll.getElementFromEnd(ll.size));
    //     Node nth = ll.getNodeFromLast(ll.size);
    //     System.out.println(nth.data);
    //     ll.deleteNodeFromLast(ll.size);
    //     ll.display();
    //     System.out.println();
    //     System.out.println(ll.tail.data);
    // }

    public static void main(String[] args) {
        

        Linkedlist ll = new Linkedlist();
        ll.insertAtEnd(11);
        ll.insertAtEnd(12);
        ll.insertAtEnd(13);
        ll.insertAtEnd(14);
        ll.insertAtEnd(15);
        ll.insertAtEnd(16);
        ll.insertAtEnd(17);
        Linkedlist mm = new Linkedlist();
        mm.insertAtEnd(20);
        mm.insertAtEnd(30);
        
    }

    
}