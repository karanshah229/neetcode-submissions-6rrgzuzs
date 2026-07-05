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
    Deque<TreeNode> dq = new ArrayDeque<TreeNode>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        dq.add(root);

        while(!dq.isEmpty()){
            int elemsToProcess = dq.size();
            List<Integer> l = new ArrayList<Integer>();

            while(elemsToProcess-- != 0){
                TreeNode node = dq.remove();

                l.add(node.val);
                
                if(node.left != null) dq.add(node.left);
                if(node.right != null) dq.add(node.right);
            }

            result.add(l);
        }

        return result;
    }
}
