/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null; // Edge case: empty list
        }

        // Create two dummy nodes for the two partitions
        ListNode lessHead = new ListNode(0); // Dummy head for "less than x"
        ListNode greaterHead = new ListNode(0); // Dummy head for "greater or equal to x"

        ListNode less = lessHead; // Pointer for the "less" partition
        ListNode greater = greaterHead; // Pointer for the "greater" partition

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                less.next = head; // Add to "less" partition
                less = less.next;
            } else {
                greater.next = head; // Add to "greater" partition
                greater = greater.next;
            }
            head = head.next; // Move to the next node
        }

        // Connect the two partitions
        greater.next = null; // End the "greater" partition
        less.next = greaterHead.next; // Connect "less" and "greater"

        return lessHead.next; // Return the merged list, skipping dummy head
    }
}
