class Solution {
    public boolean isValid(String s) {
        if (!s.isEmpty()) {
            Stack stack = new Stack();
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                    stack.push(c[i]);
                } else if (c[i] == ')') {
                    if (stack.isEmpty()) return false;
                    char temp = (char) stack.pop();
                    if (temp != '(') {
                        return false;
                    }
                } else if (c[i] == ']') {
                    if (stack.isEmpty()) return false;
                    char temp = (char) stack.pop();
                    
                    if (temp != '[' ) {
                        return false;
                    }
                } else if (c[i] == '}') {
                    if (stack.isEmpty()) return false;
                    char temp = (char) stack.pop();
                    if (temp != '{') {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
