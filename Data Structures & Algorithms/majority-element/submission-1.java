class Solution {
    public int majorityElement(int[] nums) {
         if(nums.length == 1) return nums[0];
        int target = nums.length / 2;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
                if (count > target) return nums[i];
            }
            else {
                count = 1;
            }
        }
        return -1;
    }
}