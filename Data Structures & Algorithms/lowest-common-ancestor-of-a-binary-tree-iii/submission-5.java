/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node a, Node b) {
        // keep going up from node p and node q simultaneously
        // if they meet - return that node
        // if parent of p is q or parent of q is p return that
        Node p = a, q = b;

        while(p.parent != null || q.parent != null){
            if(p.parent == q.parent) return p.parent;
            if(p.parent == null && p == q.parent) return p;
            if(q.parent == null && q == p.parent) return q;
            if(p.parent == b) return b;
            if(q.parent == a) return a;
            
            if(p.parent != null) p = p.parent;
            if(q.parent != null) q = q.parent;
        }

        return null;
    }
}