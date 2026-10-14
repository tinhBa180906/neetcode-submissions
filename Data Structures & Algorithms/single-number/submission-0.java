class Solution {
    public int singleNumber(int[] nums) {
         Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || stack.peek() != nums[i]) stack.push(nums[i]);
            else {
                stack.pop();
            }
        }
        
        return stack.pop();
    }
}
