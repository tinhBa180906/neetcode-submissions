class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         boolean[] flag = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]] = true;
        }
        ArrayList<Integer> disapearNum = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (flag[i] == false) disapearNum.add(i);
        }
        return disapearNum;
    }
}