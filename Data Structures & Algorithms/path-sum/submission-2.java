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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // if(root == null && targetSum == 0) return true;
        // if(root == null && targetSum != 0) return false;
    if(root != null && root.left == null && root.right == null && targetSum == root.val) return true;
        if(root.left != null && root.right != null) {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
         else if(root.right != null && root.left == null) {
            return  hasPathSum(root.right, targetSum - root.val);
        } else {
            return hasPathSum(root.left, targetSum - root.val);
        }
        
    }
}