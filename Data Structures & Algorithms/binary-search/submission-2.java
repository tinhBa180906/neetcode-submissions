class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //loop unitl found target or target not exist in nums
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;

            //check if taget less than element at mid
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            
            //check if target greater than element at mid
            else {
                left = mid + 1;
            }
            
            
        }
        return -1;
    }
}
