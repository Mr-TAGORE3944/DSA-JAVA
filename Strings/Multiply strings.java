To multiply two large numbers represented as strings in Java, you can't simply convert them to integers due to potential overflow issues. Instead, you can perform the multiplication manually, similar to how you would do it on paper.

Here’s an approach for multiplying two strings in Java:

```java
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        // If either string is "0", return "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];  // Array to hold the result of multiplication

        // Perform multiplication in reverse order
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];  // Add to the existing value

                result[i + j + 1] = sum % 10;  // Place the unit digit at the current position
                result[i + j] += sum / 10;  // Carry over the tens digit
            }
        }

        // Build the resulting string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {  // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        String result = multiply(num1, num2);
        System.out.println("Product: " + result);  // Expected output: "56088"
    }
}
```

### Explanation:
1. **Edge Case**: If any of the strings is `"0"`, the result is `"0"`.
2. **Reverse Multiplication**: The numbers are multiplied in reverse, similar to how multiplication is done manually.
3. **Result Array**: An array `result` of size `m + n` is used to store the result of intermediate calculations. Each position holds a digit, and the array is updated with the product and carry.
4. **Carry Handling**: Each digit's carry is added to the previous position.
5. **Building the Result**: Finally, leading zeros are skipped to form the correct result.

### Time Complexity:
- **O(m * n)** where `m` and `n` are the lengths of the two input strings.