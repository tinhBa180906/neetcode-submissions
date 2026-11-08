public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // Đoán đúng số
            } else if (res == -1) {
                high = mid - 1; // Số đoán quá lớn, giảm khoảng tìm kiếm xuống
            } else {
                low = mid + 1; // Số đoán quá nhỏ, tăng khoảng tìm kiếm lên
            }
        }
        
        return -1;
    }
}