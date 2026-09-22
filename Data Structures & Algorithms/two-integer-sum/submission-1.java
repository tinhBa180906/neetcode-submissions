class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> hash = new HashMap<>();
       
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i]) && hash.get(target - nums[i]) != i) return new int[] {i, hash.get(target - nums[i])};
        }
        return null;
    }
}
