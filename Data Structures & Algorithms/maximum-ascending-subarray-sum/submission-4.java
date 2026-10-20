class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                sum += nums[i];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            else if(nums[i] <= nums[i - 1]) {
                sum = nums[i];
            }
        }
        
        return maxSum;
    }
}