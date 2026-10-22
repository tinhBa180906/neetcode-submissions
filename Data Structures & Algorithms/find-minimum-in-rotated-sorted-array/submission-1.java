class Solution {
    public int findMin(int[] nums) {
         int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
             mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left] && nums[mid] < nums[right]) return nums[left];
            else if (nums[left] > nums[mid]) right = mid;
            else if (nums[right] < nums[mid]) left = mid + 1;
        }
        
        return nums[left];
    }
}
