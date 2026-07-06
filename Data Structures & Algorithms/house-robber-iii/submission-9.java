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
    private HashMap<TreeNode, int[]> cache = new HashMap<>();

    public int getValue(TreeNode node, boolean shouldRob) {
        if (node == null) return 0;

        int state = shouldRob ? 1 : 0;

        if (cache.containsKey(node) && cache.get(node)[state] != -1) {
            return cache.get(node)[state];
        }

        int result;

        if (node.left == null && node.right == null) {
            result = shouldRob ? node.val : 0;
        } else if (shouldRob) {
            result = getValue(node.left, false) + getValue(node.right, false) + node.val;
        } else {
            result = Math.max(getValue(node.left, true), getValue(node.left, false)) +
                     Math.max(getValue(node.right, true), getValue(node.right, false));
        }

        if (!cache.containsKey(node)) {
            cache.put(node, new int[]{-1, -1});
        }
        cache.get(node)[state] = result;

        return result;
    }

    public int rob(TreeNode root) {
        return Math.max(getValue(root, false), getValue(root, true));
    }
}