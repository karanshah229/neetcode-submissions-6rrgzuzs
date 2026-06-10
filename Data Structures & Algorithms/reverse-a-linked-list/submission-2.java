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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode temp = curr.next;
        ListNode temp2 = temp.next;
        while(temp != null){
            if(curr == head){
                curr.next = null;
            } 
            temp.next = curr;
            curr = temp;
            if(temp != null) temp = temp2;
            if(temp2 != null) temp2 = temp2.next;
        }

        return curr;
    }
}
