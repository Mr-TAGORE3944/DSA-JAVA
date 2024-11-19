import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0; // Result of the expression
        int sign = 1; // Current sign: 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Build the number
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                // Add the last number to the result with the current sign
                result += sign * num;
                num = 0; // Reset number
                sign = 1; // Update sign
            } else if (ch == '-') {
                // Subtract the last number from the result with the current sign
                result += sign * num;
                num = 0; // Reset number
                sign = -1; // Update sign
            } else if (ch == '(') {
                // Push the current result and sign to the stack for later use
                stack.push(result);
                stack.push(sign);

                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Add the last number to the result
                result += sign * num;
                num = 0;

                // Multiply the result with the sign from the stack
                result *= stack.pop(); // Pop the sign
                // Add the result to the previous result from the stack
                result += stack.pop(); // Pop the previous result
            }
        }

        // Add any remaining number to the result
        result += sign * num;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
}
