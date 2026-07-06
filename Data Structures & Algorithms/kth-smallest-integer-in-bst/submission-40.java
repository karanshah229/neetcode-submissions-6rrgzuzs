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
    private int k;
    private int ans;

    public void inorder(TreeNode node){
        if (node == null) return;

        inorder(node.left);
        
        k--;
        System.out.println(node.val + " = " + k);
        if(k == 0) {
            this.ans = node.val;
            return;
        }

        inorder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }
}
