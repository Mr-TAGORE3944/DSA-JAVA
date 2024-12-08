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
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node to handle edge cases (e.g., head is part of duplicates)
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Previous pointer to track last non-duplicate node

        while (head != null) {
            // Check if the current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect prev to the node after duplicates
                prev.next = head.next;
            } else {
                // No duplicates, move prev forward
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }
        return dummy.next;
    }
}
