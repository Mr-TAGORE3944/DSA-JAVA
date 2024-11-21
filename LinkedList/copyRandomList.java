package LinkedList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node temp = head;
        // make the interleaved of original and copied once
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // now Assign the random pointers to the Copyed list
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // now desaparate the interleaved list
        Node copyHead = head.next;
        Node original = head;
        Node copy = copyHead;
        while (original != null) {
            original.next = copy.next;
            original = original.next;

            if (original != null) {
                copy.next = original.next;
                copy = copy.next;
            }
        }

        return copyHead;
    }
}