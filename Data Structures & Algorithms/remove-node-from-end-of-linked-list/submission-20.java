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
        if (head.next == null) {
            if (n == 1)
                return null;
        }

        ListNode result = head;
        ListNode slow = null, fast = head;

        int length = 1;
        ListNode temp = head;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }

        int index = 0;
        while (fast != null) {
            if (index == (length - n)) {
                if (fast == head) {
                    return head.next; // removing the head
                }
                if (slow == null) {
                    result = fast;
                } else if (slow.next != null) {
                    slow.next = slow.next.next;
                }
                return result;
            }
            
            slow = fast;
            fast = fast.next;
            index++;
        }

        return result;
    }
}