class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // Save next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current node
            current = next; // Move to the next node
        }
        return prev; // New head of the reversed list
    }
}
