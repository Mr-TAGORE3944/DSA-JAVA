class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result list creation
        ListNode current = dummy; // Pointer to construct the result list
        int carry = 0; // Initialize carry to 0

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous step

            if (l1 != null) {
                sum += l1.val; // Add value from l1
                l1 = l1.next; // Move to the next node in l1
            }

            if (l2 != null) {
                sum += l2.val; // Add value from l2
                l2 = l2.next; // Move to the next node in l2
            }

            carry = sum / 10; // Calculate carry for the next step
            current.next = new ListNode(sum % 10); // Create a new node with the current digit
            current = current.next; // Move the pointer to the newly created node
        }

        return dummy.next; // Return the next node after the dummy node
    }
}
