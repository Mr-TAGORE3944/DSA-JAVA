/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no cycle
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect if there is a cycle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // If slow and fast meet, cycle exists
            if (slow == fast) {
                break;
            }
        }

        // If no cycle was detected (fast reached the end), return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Phase 2: Find the starting node of the cycle
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        return temp; // Start of the cycle
    }
}
