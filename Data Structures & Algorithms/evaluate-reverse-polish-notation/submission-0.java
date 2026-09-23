class Solution {
    public int evalRPN(String[] tokens) {
          Stack stack = new Stack();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                int x1 = 0, x2 = 0;
                if (!stack.empty()) {
                    x1 = (int) stack.pop();
                }
                if (!stack.empty()) {
                    x2 = (int) stack.pop();
                }
                switch (token) {
                    case "+":
                        stack.push(x1 + x2);
                        break;

                    case "-":
                        stack.push(x2 - x1);
                        break;

                    case "*":
                        stack.push(x1 * x2);
                        break;

                    case "/":
                        if (x1 != 0) {
                            stack.push(x2 / x1);
                        }
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }

        }

        return (int) stack.pop();
    }
}
