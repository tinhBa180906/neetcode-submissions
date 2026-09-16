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
    public boolean hasCycle(ListNode head) {
        // Xử lý trường hợp danh sách rỗng hoặc chỉ có 1 node
        if (head == null || head.next == null) {
            return false;
        }
        
        // Bắt đầu cuộc đua: Rùa ở vị trí thứ 1, Thỏ ở vị trí thứ 2
        return hasCycleHelper(head, head.next);
    }

    private boolean hasCycleHelper(ListNode slow, ListNode fast) {
        // ĐIỀU KIỆN DỪNG 1: Thỏ chạm đích (null) -> Không có vòng lặp
        if (fast == null || fast.next == null) {
            return false;
        }
        
        // ĐIỀU KIỆN DỪNG 2: Rùa và Thỏ gặp nhau -> Có vòng lặp
        if (slow == fast) {
            return true;
        }
        
        // BƯỚC ĐỆ QUY: Rùa đi 1 bước, Thỏ đi 2 bước
        return hasCycleHelper(slow.next, fast.next.next);
    }
}
