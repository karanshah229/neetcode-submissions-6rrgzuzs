/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copy = head, res = null;
        HashMap<Node, Node> hm = new HashMap<>();

        while(head != null){
            //main node
            if(hm.containsKey(head)) {
                copy = hm.get(head);
            } else {
                copy = new Node(head.val);
                hm.putIfAbsent(head, copy);
            }

            if(res == null) res = copy;
            
            // next node
            if(head.next == null) copy.next = null;
            else {
                if(hm.containsKey(head.next)) {
                    copy.next = hm.get(head.next);
                } else {
                    copy.next = new Node(head.next.val);
                    hm.putIfAbsent(head.next, copy.next);
                }
            }
            
            // random node
            if(head.random == null) copy.random = null;
            else {
                if(hm.containsKey(head.random)) {
                    copy.random = hm.get(head.random);
                } else {
                    copy.random = new Node(head.random.val);
                    hm.putIfAbsent(head.random, copy.random);
                }
            }

            head = head.next;
        }

        return res;
    }
}
