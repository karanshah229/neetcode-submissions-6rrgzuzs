/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. if p, q are on opposite side - curr is lca
        // 2. Variation of 1 - if curr is either p or q & other is in it's subtree - curr is lca

        // algo
        // if same side - keep doing recur left + recur right
        // if opp side - short circuit based on 1
        if(root == null) return null;
        if(p == null || q == null) return null;

        if((p.val <= root.val && q.val >= root.val) || 
        (q.val <= root.val && p.val >= root.val)) return root;
        if(p.val == root.val || q.val == root.val) return root;

        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
