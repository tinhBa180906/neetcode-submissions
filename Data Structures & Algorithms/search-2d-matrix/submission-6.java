class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length - 1;
        
        while (up <= down) {
            int mid1 = up + (down - up) / 2;
            
            if (matrix[mid1][0] <= target && matrix[mid1][matrix[0].length-1] >= target) {
                int right = matrix[0].length - 1;
                int left = 0;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[mid1][mid] == target) return true;
                    else if (target > matrix[mid1][mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return false;
            }
            
            else if (matrix[mid1][matrix[0].length - 1] > target) {
                down = mid1 - 1;
            } else {
                up = mid1 + 1;
            }
        }
        
        return false;
    }
}
