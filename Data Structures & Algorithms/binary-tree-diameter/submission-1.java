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
     public int diameterOfBinaryTree(TreeNode root) {
       
         if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int maxLength = 0;
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            int length = dfs(current.left) + dfs(current.right);
            if (length > maxLength) maxLength = length;
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        
        return maxLength;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
