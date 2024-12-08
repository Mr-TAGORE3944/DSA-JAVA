import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Stack<Integer> st = new Stack<>();
        char sign = '+';
        int num = 0;

        // Remove spaces for easier processing
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If operator or last character, process the sign
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num); // Assume no division by zero as per problem constraints
                        break;
                }
                sign = ch; // Update sign
                num = 0; // Reset number
            }
        }

        // Sum up all elements in the stack
        int result = 0;
        for (int n : st) {
            result += n;
        }

        return result;
    }
}
