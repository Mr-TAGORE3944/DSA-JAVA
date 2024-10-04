import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with -1 to handle edge cases.
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Pop for a matching '('
                if (stack.isEmpty()) {
                    stack.push(i); // Push the current index as a boundary.
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()))())(";
        System.out.println(solution.longestValidParentheses(s)); // Output: 4
    }
}
