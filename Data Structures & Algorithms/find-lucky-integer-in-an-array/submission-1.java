class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> freq : freqMap.entrySet()) {
            if(freq.getKey() == freq.getValue() && maxKey < freq.getKey()) {
                maxKey = freq.getKey();
            }
        }
        
        return maxKey;
    }
}