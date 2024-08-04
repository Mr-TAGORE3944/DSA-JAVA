package LinkedList;

public class mergeSortLL {
    class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Function to print the LinkedList
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to split the linked list into two halves
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

    // Function to merge two sorted linked lists
    Node sortedMerge(Node a, Node b) {
        Node result;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // Function to perform MergeSort on the linked list
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
        LinkedList list = new LinkedList();
        list.head = new Node(15);
        list.head.next = new Node(10);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(3);
        list.head.next.next.next.next.next = new Node(2);

        System.out.println("Unsorted Linked List:");
        list.printList(list.head);

        list.head = list.mergeSort(list.head);

        System.out.println("Sorted Linked List:");
        list.printList(list.head);
    }
}

}
