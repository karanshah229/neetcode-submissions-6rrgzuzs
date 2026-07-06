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
    public void remove(TreeNode node, int target){
        if(node.left == null && node.right == null && node.val == target) node.val = Integer.MIN_VALUE;

        if(node.left != null) remove(node.left, target);
        if(node.right != null) remove(node.right, target);

        if(
            ( (node.left != null && node.left.val == Integer.MIN_VALUE) || node.left == null) &&
            ( (node.right != null && node.right.val == Integer.MIN_VALUE) || node.right == null ) &&
            node.val == target
        ) {
            node.val = Integer.MIN_VALUE;
            node.left = null;
            node.right = null;
        }

        if(node.left != null && node.left.val == Integer.MIN_VALUE) node.left = null;
        if(node.right != null && node.right.val == Integer.MIN_VALUE) node.right = null;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode res = root;
        remove(root, target);
        if(res.val == Integer.MIN_VALUE) return null;
        return res;
    }
}