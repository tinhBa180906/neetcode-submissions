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
    public void reorderList(ListNode head) {
       if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fash = head;
        while (fash != null && fash.next != null){
            slow = slow.next;
            fash = fash.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        //reverse halfList
        ListNode reverseHalf = reverseList(secondHalf);
        
        
        //point head to reverse list
        ListNode run = head;
        while (reverseHalf != null) {
            ListNode nextNodeRun = run.next;
            ListNode nextNodeReverse = reverseHalf.next;
            run.next = reverseHalf;
            reverseHalf.next = nextNodeRun;
            run = nextNodeRun;
            reverseHalf  = nextNodeReverse;
        }
}
public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next; // Bước 1
            curr.next = prev; // Bước 2
            prev = curr;      // Bước 3
            curr = next;      // Bước 4
        }
        return prev;
    }
}