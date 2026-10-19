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
        ArrayList<Integer> result = new ArrayList<>();
        return inorder(root, result);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> result) {
        if(root != null) {
            result = inorder(root.left, result);
            result.add(root.val);
            result = inorder(root.right, result);
        }
        return result;
    }

}