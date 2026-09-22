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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(-1, null);
        ListNode result = dummy;
        int rem = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + rem;

            dummy.next = new ListNode(temp % 10, null);
            if (temp >= 10) {
                rem = 1;
            } else {
                rem = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }
        
        while (l1 != null) {
            int temp = l1.val + rem;

            dummy.next = new ListNode(temp % 10, null);
            if (temp >= 10) {
                rem = 1;
            } else {
                rem = 0;
            }
            l1 = l1.next;
            dummy = dummy.next;
        }
        
        while (l2 != null) {
            int temp = l2.val + rem;

            dummy.next = new ListNode(temp % 10, null);
            if (temp >= 10) {
                rem = 1;
            } else {
                rem = 0;
            }
            l2 = l2.next;
            dummy = dummy.next;
        }
        
        if (rem == 1) {
            dummy.next = new ListNode(1, null);
        }
        return result.next;
    }
}
