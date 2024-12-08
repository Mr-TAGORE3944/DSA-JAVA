class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // Handle closing brackets
                if (st.isEmpty()) { // No matching opening bracket
                    return false;
                }

                char top = st.pop(); // Check top of the stack
                if (!((top == '(' && ch == ')') ||
                        (top == '{' && ch == '}') ||
                        (top == '[' && ch == ']'))) {
                    return false; // Mismatch
                }
            }
        }

        // If the stack is empty, the string is valid
        return st.isEmpty();
    }
}
