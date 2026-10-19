class Solution {
     public TreeNode sortedArrayToBST(int[] nums) {
        return sortToBST(nums, 0, nums.length - 1);
    }
    
   public TreeNode sortToBST(int[] nums, int left, int right) {
      if(left <= right) {
           int mid = left + (right - left) / 2;
           TreeNode result = new TreeNode(nums[mid]);
           
           result.left = sortToBST(nums, left, mid - 1);
           result.right = sortToBST(nums, mid + 1, right);
           
           return result;
       }
       return null;
       
   }
}
