class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        Integer[] numsObj = new Integer[nums.length];
        int j = 0;
        for(int i : nums) {
            numsObj[j++] = i;
        }
        Arrays.sort(numsObj, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if(freqA != freqB) return Integer.compare(freqA, freqB);
            return Integer.compare(b, a);
        });
        int k = 0;
        for (Integer i : numsObj) {
            nums[k++] = i;
        }
        return nums;
    }
}