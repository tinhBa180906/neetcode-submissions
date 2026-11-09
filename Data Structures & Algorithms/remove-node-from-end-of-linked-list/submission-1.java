/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) return null;
        ListNode run = head;
        int length = 0;
        while (run != null) {
            length++;
            run = run.next;
        }
        
        
        
        if (length - n == 0) {
            return head.next;
        }
        ListNode prev = head;
        ListNode current = head.next;
        ListNode result = head;
        int i = 1;
        while (current != null) {
            if (i == length - n) {
                prev.next = current.next;
                current.next = null;
                return result;
            }
            i++;
            prev = prev.next;
            current = current.next;
        }
        return null;

    }
}
