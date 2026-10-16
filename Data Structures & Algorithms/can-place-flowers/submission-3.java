class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
          int count = 0;
        int len = flowerbed.length;
        if (len == 1) {
            if (flowerbed[0] == 0) {
                flowerbed[0] = 1;
                count++;
            }
            return count >= n;
        }
        for (int i = 0; i < flowerbed.length; i++) {

            if (i == 0) {
                if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    count++;
                    continue;
                }
            }

            else if (i == len - 1) {
                if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
                    flowerbed[len - 1] = 1;
                    count++;
                    continue;
                }
            }

            else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }

        }
        return count >= n;
    }
}