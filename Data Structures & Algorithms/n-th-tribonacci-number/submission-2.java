class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
         int[] rem = new int[n + 1];
        rem[0] = 0;
        rem[1] = 1;
        rem[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            rem[i] = rem[i - 3] + rem[i - 1] + rem[i - 2];
        }
        
        return rem[n];
    }
}