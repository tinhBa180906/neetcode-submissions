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
    public TreeNode deleteNode(TreeNode root, int key) {
         //tim node p chua x, va father cua p
        TreeNode p = root;
        TreeNode father = null;
        //loop to access elemt
        while (p != null) {
            if (p.val == key) {
                break;
            } else if (key < p.val) {
                father = p;
                p = p.left;
            } else {
                father = p;
                p = p.right;
            }
        }

        if (p != null) {
            //p co 2 con
            if (p.left != null && p.right != null) {
                //tim pMax la node lon nhat cua cua con trai va fmax la cha cua pmax
                TreeNode pMax = p.left;
                TreeNode fmax = p;
                while (pMax.right != null) {
                    fmax = pMax;
                    pMax = pMax.right;
                }

                //copy pmax vao p
                p.val = pMax.val;
                //cap nhat p = pmax de xoa p
                p = pMax;
                father = fmax;
            }
            //xoa p co 1 con hoac la khong co con
            TreeNode child = p.left == null ? p.right : p.left;
            //noi father voi node child
            if (father == null) {
                root = child;
            } else if (father.left == p) {
                father.left = child;
            } else {
                father.right = child;
            }

            p.left = p.right = null;
        }
        
        return root;
    }
}