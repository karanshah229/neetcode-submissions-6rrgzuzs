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
    public int depth(TreeNode root){
        if(root.left == null) {
            if(root.right == null) return 1;
            if(root.right != null) {
                return depth(root.right) + 1;
            }
        } else {
            if(root.right == null) return depth(root.left) + 1;
            else return Math.max(depth(root.left), depth(root.right)) + 1;
        }

        return 0;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return depth(root);
    }
}
