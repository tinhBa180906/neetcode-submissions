class Solution {
    public boolean isMonotonic(int[] nums) {
         int i = 0;
        boolean check = false;
        for (; i < nums.length - 1; i++) {
            if (nums[i] < nums[i +1]) {
                check = true;
                break;
            } else if (nums[i] > nums[i + 1]) {
                break;
            }
        }
        if (check) {
            for (int k = i; k < nums.length - 1; k++) {
                if (nums[k] > nums[k + 1]) return false;
            }
        } else{
            for (int k = i; k < nums.length - 1; k++) {
                if (nums[k] < nums[k + 1]) return false;
            }
        }
        
        return true;
    }
}