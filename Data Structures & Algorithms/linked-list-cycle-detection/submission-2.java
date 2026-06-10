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
        if(head == null) return false;

        ListNode fast = head;
        ListNode slow = fast;
        int moves = 0;

        while(fast.next != null){
            fast = fast.next;
            moves++;
            if(moves % 2 == 0 && moves != 0) slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }
}
