class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
         if (s1.equals(s2)) {
            return true;
        }
        else {
            char[] char1 = s1.toCharArray();
            Arrays.sort(char1);
            String ch1 = String.valueOf(char1);
            
            char[] char2 = s2.toCharArray();
            Arrays.sort(char2);
            String ch2 = String.valueOf(char2);
            if(!ch1.equals(ch2)) return false;
            int[] flag = new int[2];
            int j = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if(j >= 2) return false;
                    flag[j] = i;
                    j++;
                    
                }
            }
            
            return  (s1.charAt(flag[0]) == s2.charAt(flag[1])) && (s1.charAt(flag[1]) == s2.charAt(flag[0]));
        }
    }
}
