class Solution {
    public int countSeniors(String[] details) {
         int result = 0;
        for (String s : details) {
            int age = Integer.parseInt(s.substring(11, 13));
            if(age > 60) result++;
        }
        
        return result;
    }
}