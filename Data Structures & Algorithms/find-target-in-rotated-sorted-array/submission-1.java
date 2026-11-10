class Solution {
    public int search(int[] nums, int target) {
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                r = i + 1;
                break;
            }
        }
        int left = 0;
        int right = r - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        left = r;
        right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
