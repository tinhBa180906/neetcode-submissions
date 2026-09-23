class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            stack.push((int)temperatures[i]);
            int temp = (int)stack.peek();
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temp) {
                    result[i] = j - i;
                    stack.clear();
                    break;
                }
            }
        }
        
        return result;
    }
}
