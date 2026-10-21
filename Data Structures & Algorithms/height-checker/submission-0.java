class Solution {
    public int heightChecker(int[] heights) {
          int[] copyArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copyArray);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != copyArray[i]) count++;
        }
        
        return count;
    }
}