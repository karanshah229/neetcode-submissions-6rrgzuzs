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
    public void invert(TreeNode root){
        if(root == null) return;
        
        System.out.println(root.val);

        if(root != null){
            System.out.println(root.val);
            if(root.left == null){
                if(root.right != null) {
                    root.left = root.right;
                    root.right = null;
                }
                // if(root.right == null) continue;
            } else {
                TreeNode temp = root.left;
                if(root.right != null) {
                    root.left = root.right;
                    root.right = temp;
                } else {
                    root.right = temp;
                    root.left = null;
                }
            }
        }
        invert(root.left);
        if(root.right != null) invert(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode res = root;
        invert(root);
        return res;
    }
}
