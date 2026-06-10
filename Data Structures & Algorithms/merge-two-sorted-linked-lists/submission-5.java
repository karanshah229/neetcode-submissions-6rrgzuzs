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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        ListNode merged = new ListNode();
        ListNode result = merged;

        while(head1 != null && head2 != null){
            ListNode temp;
            if(head1.val < head2.val) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            merged.val = temp.val;
            if(temp != null) {
                merged.next = new ListNode();
                merged = merged.next;
            }
        }

        while(head1 != null){
            merged.val = head1.val;
            head1 = head1.next;
            if(head1 != null) {
                merged.next = new ListNode();
                merged = merged.next;
            }
        }

        while(head2 != null){
            merged.val = head2.val;
            head2 = head2.next;
            if(head2 != null) {
                merged.next = new ListNode();
                merged = merged.next;
            }
        }

        merged = null;

        return result;
    }
}