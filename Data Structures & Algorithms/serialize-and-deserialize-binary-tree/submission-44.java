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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        List<String> arr = new ArrayList<>();
        Deque<TreeNode> aq = new ArrayDeque<>();
        aq.add(root);

        while(aq.size() != 0){
            TreeNode node = aq.remove();
            arr.add(node.val == Integer.MIN_VALUE ? "null" : Integer.toString(node.val));
            
            if(node.left != null) aq.add(node.left);
            else if(node.val != Integer.MIN_VALUE) aq.add(new TreeNode(Integer.MIN_VALUE));
            
            if(node.right != null) aq.add(node.right);
            else if(node.val != Integer.MIN_VALUE) aq.add(new TreeNode(Integer.MIN_VALUE));
        }

        return arr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        if(str == "") return null;

        System.out.println(str);

        String cleanStr = str.substring(1, str.length() - 1);
        String[] tokens = cleanStr.split(",\\s*");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode current = queue.poll();
            
            if (current != null) {
                if (!tokens[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(tokens[i]));
                    queue.add(current.left);
                }
                i++;
                
                if (i < tokens.length && !tokens[i].equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(tokens[i]));
                    queue.add(current.right);
                }
                i++;
            }
        }

        return root;
    }
}
