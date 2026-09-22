class Solution {
    public boolean isPalindrome(String s) {
         String[] parts = s.split("[^a-zA-Z0-9]+");
        String s1 = String.join("", parts);
        
         String s2 ="";
        for(int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }
        
         return s1.equalsIgnoreCase(s2);

    }
}
