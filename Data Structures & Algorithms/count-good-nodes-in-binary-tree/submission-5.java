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

    public int good(TreeNode node, int maxSoFar){
        int count = maxSoFar <= node.val ? 1 : 0;
        int lcount = 0, rcount = 0;
        if(node.left != null){
            lcount = good(node.left, Math.max(maxSoFar, node.val));
        }

        if(node.right != null){
            rcount = good(node.right, Math.max(maxSoFar, node.val));
        }

        return count + lcount + rcount;
    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return good(root, root.val);
    }
}
