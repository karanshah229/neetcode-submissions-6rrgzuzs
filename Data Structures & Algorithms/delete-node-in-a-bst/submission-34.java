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
    public TreeNode delete(TreeNode node, int key){
        if (node == null) return null;

        if(key < node.val) node.left = delete(node.left, key);
        else if(key > node.val) node.right = delete(node.right, key);
        else {
            // match
            if(node.left == null && node.right == null) return null;
            else if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else {
                TreeNode leftMostRight = node.right, p = node;
                while(leftMostRight.left != null) {
                    p = leftMostRight;
                    leftMostRight = leftMostRight.left;
                }
                node.val = leftMostRight.val;
                
                if (p == node) p.right = leftMostRight.right;
                else p.left = leftMostRight.right;

                return node;
            }
        }
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        return delete(root, key);
    }
}