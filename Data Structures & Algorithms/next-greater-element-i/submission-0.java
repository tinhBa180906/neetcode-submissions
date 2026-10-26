class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterResult = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            stack.push(nums1[i]);
        }
        
        int index = nums1.length - 1;
        boolean flag = false;
        while(!stack.isEmpty() && index >= 0) {
            int currentVal = stack.pop();
            for (int i = 0; i < nums2.length; i++) {
                if(nums2[i] == currentVal) {
                    for (int j = i + 1; j < nums2.length; j++) {
                        if(nums2[j] > currentVal) {
                            nextGreaterResult[index--] = nums2[j];
                            flag = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if(!flag) {
                nextGreaterResult[index--] = -1;
            } else {
                flag = false;
            }
        }
        return nextGreaterResult;
    }
}