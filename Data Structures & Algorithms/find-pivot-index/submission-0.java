class Solution {
    public int pivotIndex(int[] nums) {
         int pivot = 0;
        int left = 0;
        int right = nums.length;
        while (pivot < right) {
            //sum form left to pivot(1)
            int leftValue = 0;
            for (int i = left; i < pivot; i++) {
                leftValue += nums[i];
            }
            
            //sum pivot to right (2)
            int rightValue = 0;
            for (int i = pivot + 1; i < right; i++) {
                rightValue += nums[i];
            }
            
            //check if (1) == 2
            if (leftValue == rightValue) {
                return pivot;
            }
            
            pivot++;
        }
        
        return -1;
    }
}