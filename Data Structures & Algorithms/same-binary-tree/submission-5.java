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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
            return true;
        }
        
        else if (p == null && q != null) return false;
        else if (p != null && q == null) return false;

        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();

        que1.add(p);
        que2.add(q);

        while (!(que1.isEmpty() && que2.isEmpty())) {
            TreeNode current1 = que1.remove();
            TreeNode current2 = que2.remove();
            //so sanh o day
            if (current1 == null && current2 != null) return false;
            else if (current1 != null && current2 == null) return false;
            else if (current1.left == null && current2.left != null) return false;
            else if (current1.left != null && current2.left == null) return false;
            else if (current1.right == null && current2.right != null) return false;
            else if (current1.right != null && current2.right == null) return false;
            
            
            
            if (current1 != null && current2 != null && current1.val != current2.val) {
                return false;
            }
            if (current1 != null && current1.left != null) {
                if (current2.left == null) {
                    return false;
                }
                que1.add(current1.left);
                que2.add(current2.left);
            }
            if (current2 != null && current2.right != null) {
                if (current2.right == null) {
                    return false;
                }
                que1.add(current1.right);
                que2.add(current2.right);
            }
            
        }

        return true;

    }
}
