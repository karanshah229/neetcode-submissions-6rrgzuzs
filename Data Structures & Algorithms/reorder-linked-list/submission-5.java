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
    public void reorderList(ListNode head2) {
        ListNode head = head2;
        ListNode start = head;
        ListNode end = head;
        ArrayDeque<ListNode> aq = new ArrayDeque<>();

        while(end.next != null){
            aq.push(end);
            end = end.next;
        }
        aq.push(end);
        end = aq.pop();

        boolean takeFromstart = true;
        while(start != end){
            if(takeFromstart){
                if(start == head) {
                    start = start.next;
                } else {
                    head.next = start;
                    head = head.next;
                    start = start.next;
                }
                takeFromstart = false;
            } else {
                head.next = end;
                head = head.next;
                end = aq.pop();
                takeFromstart = true;
            }
        }
            
            head.next = end;
            head = head.next;
            head.next = null;
    }
}
