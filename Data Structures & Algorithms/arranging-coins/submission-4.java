class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int run = n;
        for (int i = 0; i <= n; i++) {
            if(run < i) return count - 1;
            count++;
            run -= i;
        }
        return count - 1;
    }
}