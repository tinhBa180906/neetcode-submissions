class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words = (s1 + " " + s2).split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String result = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if(e.getValue() == 1) result += e.getKey() + " ";
        }
        
                return result.split("\\s+")[0].equals("") ? new String[0] : result.split("\\s+") ;

    }
}
