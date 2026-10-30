class Solution {
    public boolean isUgly(int n) {
        if (n == 1) return true;
        int[] primeFactor = {2, 3, 5};
        while(n > 1) {
            if (n % 2 == 0)  n /= 2;
            if(n % 5 == 0) n/= 5;
            if(n % 3 == 0) n/= 3;
            if(n % 2 != 0 && n % 5 != 0 && n % 3 != 0) break;
        }

        return n == 1;
    }
}