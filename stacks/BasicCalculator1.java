import java.util.Stack;

public class BasicCalculator1 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        s = s.replaceAll(" ", ""); // Remove spaces

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Build the number
            }

            // If the character is an operator or the last character of the string
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = ch; // Update the current sign
                num = 0; // Reset the number
            }
        }

        // Sum up all values in the stack
        int result = 0;
        for (int value : stack) {
            result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator1 calculator = new BasicCalculator1();
        System.out.println(calculator.calculate("3+2*2")); // Output: 7
        System.out.println(calculator.calculate(" 3/2 ")); // Output: 1
        System.out.println(calculator.calculate(" 3+5 / 2 ")); // Output: 5
    }
}
