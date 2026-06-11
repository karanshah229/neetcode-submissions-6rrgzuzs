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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = head, end = head;

        // FIX 1: Adjust loop bounds to stop exactly at the 1-based index positions
        while(--left > 0) start = start.next;
        while(--right > 0) end = end.next;
        
        // FIX 2: Keep reference to head to return the full list at the end
        ListNode res = head; 

        // FIX 3: Collect values into an array to properly swap backward and forward
        List<Integer> values = new ArrayList<>();
        ListNode curr = start;
        while(curr != end.next){
            values.add(curr.val);
            curr = curr.next;
        }

        // FIX 4: Overwrite the list values in reversed order
        curr = start;
        for(int i = values.size() - 1; i >= 0; i--){
            curr.val = values.get(i);
            curr = curr.next;
        }

        return res;

    }
}