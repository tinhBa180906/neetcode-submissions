class Solution {
    public int maxDifference(String s) {
         Map<Character, Integer> mapFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapFreq.put(c, mapFreq.getOrDefault(c, 0) + 1);
        }
        
        int maxOddFreq = 0;
        int minEvenFreq = 999;
        for (Map.Entry<Character, Integer> entry : mapFreq.entrySet()) {
            if(entry.getValue() % 2 != 0 && entry.getValue() > maxOddFreq) maxOddFreq = entry.getValue();
            if (entry.getValue() % 2 == 0 && entry.getValue() < minEvenFreq) minEvenFreq = entry.getValue();
        }
        
        return maxOddFreq - minEvenFreq;
    }
}