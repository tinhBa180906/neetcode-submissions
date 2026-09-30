class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null) {
            return false;
        }
        int[] row = null;
        int len = matrix.length;

        for (int[] ints : matrix) {

            if (ints[0] <= target && target <= ints[ints.length - 1]) {
                row = ints;
                break;
            }
        }
        if (row == null) return false;
        int l = 0;
        int r = row.length-1;
        while(l<=r) {
            int mid= l+(r-l)/2;
            if(target==row[mid]) {
                return true;
            } if(target<row[mid]) {
                r = mid-1;
            } else if(target>row[mid]) {
                l= mid+1;
            }
        }
        return false;

    }
}
