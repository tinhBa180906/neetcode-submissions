class Solution {
    public int[] productExceptSelf(int[] nums) {
         int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int[] result = new int[nums.length];
        int prePro = 1;
        for (int i = 0; i < nums.length; i++) {

            pre[i] = prePro;
            prePro *= nums[i];
        }
        int postPro = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = postPro;
            postPro *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * post[i];
        }
        return result;
    }
}  
