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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> aq = new ArrayDeque<>();
        
        while(root != null || !aq.isEmpty()){
            if(root != null){
                aq.push(root);
                root = root.left;
            } else {
                root = aq.pop();
                res.add(root.val);
                root = root.right;

            }
        }

        return res;
    }
}