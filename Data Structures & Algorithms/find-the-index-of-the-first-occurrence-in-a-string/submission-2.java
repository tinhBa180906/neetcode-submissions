class Solution {
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (haystack.equals(needle)) return 0;
        if (length2 > length1) return -1;
        for (int i = 0; i < length1 - length2 + 1; i++) {
            if (haystack.substring(i, i + length2).equals(needle)) return i;
        }
        
        return -1;
    }
}