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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode[] pointers = new ListNode[lists.length];
        ListNode res = new ListNode(), curr = res;

        int i = 0;
        for (ListNode l : lists) pointers[i++] = l;

        while (true) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;

            for (i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= minVal) {
                    minVal = lists[i].val;
                    minIndex = i;
                }
            }

            if (minIndex == -1) break;

            curr.next = lists[minIndex];
            curr = curr.next;

            lists[minIndex] = lists[minIndex].next;
        }

        return res.next;
    }
}
