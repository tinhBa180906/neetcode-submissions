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
     public boolean isSymmetric(TreeNode root) {

        //inverse left 
        TreeNode inverseLeft = invertTree(root.left);
        
        
        //check same 
        return checkSameTree(inverseLeft, root.right);
    }
    
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
    
    
    
    public boolean checkSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right);
    }
}
