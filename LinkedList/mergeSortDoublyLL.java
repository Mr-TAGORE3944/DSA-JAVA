package LinkedList;
public class mergeSortDoublyLL {
    class DoublyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Function to print the Doubly LinkedList
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to split the doubly linked list into two halves
    Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted doubly linked lists
    Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = sortedMerge(a.next, b);
            a.next.prev = a;
            a.prev = null;
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            b.next.prev = b;
            b.prev = null;
            return b;
        }
    }

    // Function to perform MergeSort on the doubly linked list
    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Get the middle of the list
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on both halves
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // Merge the sorted halves
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.head = new Node(15);
        list.head.next = new Node(10);
        list.head.next.prev = list.head;
        list.head.next.next = new Node(5);
        list.head.next.next.prev = list.head.next;
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.prev = list.head.next.next;
        list.head.next.next.next.next = new Node(3);
        list.head.next.next.next.next.prev = list.head.next.next.next;
        list.head.next.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next.prev = list.head.next.next.next.next;

        System.out.println("Unsorted Doubly Linked List:");
        list.printList(list.head);

        list.head = list.mergeSort(list.head);

        System.out.println("Sorted Doubly Linked List:");
        list.printList(list.head);
    }
}

}
