class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int[] result = new int[temperatures.length];
        Stack stack = new Stack();
         for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[(int) stack.peek()]) {
                int pre = (int) stack.pop();
                
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        
        return result;
    }
}
