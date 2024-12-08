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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // Edge cases: empty list, single node, or no rotation
        }

        // Step 1: Compute the length of the list
        int length = 1; // Start at 1 to include the head
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Find the effective number of rotations
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Locate the new head
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 4: Perform the rotation
        ListNode newHead = newTail.next;
        newTail.next = null; // Break the connection
        tail.next = head; // Connect the old tail to the old head

        return newHead;
    }
}
