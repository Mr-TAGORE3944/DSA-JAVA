package LinkedList;

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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        ListNode current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        first = current;

        while (current.next != null) {
            current = current.next;
            second = second.next;
        }

        second = second.next;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return dummy.next;
    }
}

/*
 * /**
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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode first = null;
        ListNode last = null;
        ListNode current = head;
        ListNode slow = head;
        ListNode prev = null;
        int count = 0;

        while (current != null) {
            count++;
            if (count == k) {
                first = current;
            }
            if (count > k) {
                slow = slow.next;
            }
            prev = current;
            current = current.next;
        }
        last = slow;

        if (first == null || last == null)
            return head;
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
        return head;
    }
}

/*
 * 
 * 
 * 
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * class Solution {
 * public ListNode swapNodes(ListNode head, int k) {
 * if(head == null || head.next == null)
 * return head;
 * ListNode first = null;
 * ListNode last = null;
 * ListNode current = head;
 * ListNode slow = head;
 * ListNode prev = null;
 * int count = 0;
 * 
 * while(current != null) {
 * count++;
 * if(count == k) {
 * first = current;
 * }
 * if(count > k) {
 * slow = slow.next;
 * }
 * prev = current;
 * current = current.next;
 * }
 * last = slow;
 * 
 * if(first == null || last == null)
 * return head;
 * int tmp = first.val;
 * first.val = last.val;
 * last.val = tmp;
 * return head;
 * }
 * }
 * 
 * 
 * 
 * 
 */