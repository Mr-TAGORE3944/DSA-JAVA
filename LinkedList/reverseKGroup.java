package LinkedList;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if we have enough nodes to reverse
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {
            // Reverse the first k nodes
            ListNode reversedHead = reverseFirstK(head, k);
            // Recursively reverse the rest of the list
            head.next = reverseKGroup(current, k);
            return reversedHead;
        }

        return head; // If less than k nodes, return the head as is
    }

    private ListNode reverseFirstK(ListNode head, int k) {
        ListNode prev = null, current = head, next = null;
        while (k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
