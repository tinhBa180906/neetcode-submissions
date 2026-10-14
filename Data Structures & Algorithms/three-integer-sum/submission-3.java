class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[ i- 1]) continue;;
            int target = 0 - nums[i];
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    } 
                    while(left<right && nums[right] == nums[right + 1])
                        right--;

                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return result;
    }
}
