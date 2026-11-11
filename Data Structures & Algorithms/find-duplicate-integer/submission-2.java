class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] checkExist = new boolean[nums.length + 1];
        for(int num : nums) {
            if (checkExist[num]) return num;
            checkExist[num] = true;
        }
        return -1;
    }
}
