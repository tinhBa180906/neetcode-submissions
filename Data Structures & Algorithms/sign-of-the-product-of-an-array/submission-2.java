class Solution {
    public int arraySign(int[] nums) {
        boolean checkZero = false;
        int countNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) checkZero = true;
            else if (nums[i] < 0) countNegative++;
        }
        
        if(checkZero) return 0;
        if (countNegative != 0 && countNegative % 2 != 0) return -1;
        return 1;

    }
}