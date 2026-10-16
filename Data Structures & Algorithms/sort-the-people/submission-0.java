class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         for(int i = 0; i < names.length - 1; i++) {
            for(int j = i + 1; j < names.length; j++) {
                if (heights[j] > heights[i]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                    String t = names[i];
                    names[i] = names[j];
                    names[j] = t;
                }
            }
        }
        return names;
    }
}