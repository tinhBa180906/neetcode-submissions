class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * (heights[left] > heights[right] ? heights[right] : heights[left]);
            if(area > maxArea) maxArea = area;
            if(heights[right] <= heights[left]) right--;
            else left++;
        }
        
        
        return maxArea;
    }
}
