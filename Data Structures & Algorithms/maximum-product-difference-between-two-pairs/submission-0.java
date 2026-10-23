class Solution {
    public int maxProductDifference(int[] nums) {
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArray);
        return (copyArray[nums.length - 1] * copyArray[nums.length - 2] - copyArray[0] * copyArray[1]);
    }
}