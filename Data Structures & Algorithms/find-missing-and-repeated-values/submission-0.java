class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
         Set<Integer> check = new HashSet<>();
        boolean[] checkMissing = new boolean[grid.length * grid.length + 1];
        int[] result = new int[2];
        for (int[] is : grid) {
            for (int i : is) {
                if(check.contains(i)) result[0] = i;
                else {
                    check.add(i);
                    checkMissing[i] = true;
                }
            }
        }
        
        for (int i = 0; i < checkMissing.length; i++) {
            if(!checkMissing[i]) result[1] = i ;
        }
        
        return result;
    }
}