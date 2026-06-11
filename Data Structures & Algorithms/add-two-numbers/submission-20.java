class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head to easily attach new nodes and return the result
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Traverse both lists until both are fully processed and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the previous carry

            // Add value from l1 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate the new carry and the digit to store
            carry = sum / 10;
            current.next = new ListNode(sum % 10);

            // Move the pointer forward
            current = current.next;
        }

        // Return the actual head, skipping the dummy head
        return dummyHead.next;
    }
}
