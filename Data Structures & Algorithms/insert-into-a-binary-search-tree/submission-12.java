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
    public void insert(TreeNode node, int val){
        System.out.println(node.val);
        if(node.left == null && val < node.val) node.left = new TreeNode(val);
        else if(node.right == null && val > node.val) node.right = new TreeNode(val);
        else {
            if(val > node.val) insert(node.right, val);
            else insert(node.left, val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ret = root;

        if(root == null) return new TreeNode(val);

        insert(root, val);
        
        return ret;
    }
}