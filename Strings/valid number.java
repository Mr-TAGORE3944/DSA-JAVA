// A valid number is defined as a string that can be interpreted as a
// floating-point or integer number. This includes:

// - An optional leading sign (`+` or `-`).
// - An integer or decimal number with optional digits after the decimal point.
// - An optional exponent part, which starts with `e` or `E`, followed by an
// optional sign and digits.

// Some valid numbers:
// - `"2"`
// - `"-2.5"`
// - `"3.1416"`
// - `"-.1"`
// - `"2e10"`
// - `"2E-10"`

// Here’s a Java solution using a state machine to determine whether a string is
// a valid number:

// ```java
// public class ValidNumber {
// public boolean isNumber(String s) {
// // Trim the string to remove leading and trailing whitespaces
// s = s.trim();

// // Flags to track different parts of a valid number
// boolean hasNum = false; // To track if there's at least one digit
// boolean hasDot = false; // To track if there's a decimal point
// boolean hasExp = false; // To track if there's an exponent ('e' or 'E')

// int n = s.length();

// for (int i = 0; i < n; i++) {
// char c = s.charAt(i);

// if (Character.isDigit(c)) {
// hasNum = true; // There is at least one digit
// } else if (c == '.') {
// // If there's already a decimal point or exponent, return false
// if (hasDot || hasExp) return false;
// hasDot = true; // Mark that we've encountered a decimal point
// } else if (c == 'e' || c == 'E') {
// // Exponent should only appear once, and there must be a number before it
// if (hasExp || !hasNum) return false;
// hasExp = true; // Mark that we've encountered an exponent
// hasNum = false; // Reset hasNum, because there must be digits after 'e' or
// 'E'
// } else if (c == '+' || c == '-') {
// // Sign is valid only at the start or immediately after an exponent
// if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
// } else {
// // Any other character is invalid
// return false;
// }
// }

// // The string is valid if it contains at least one digit and no other issues
// were found
// return hasNum;
// }

// public static void main(String[] args) {
// ValidNumber validator = new ValidNumber();

// // Test cases
// System.out.println(validator.isNumber("2")); // true
// System.out.println(validator.isNumber("0089")); // true
// System.out.println(validator.isNumber("-0.1")); // true
// System.out.println(validator.isNumber("+3.14")); // true
// System.out.println(validator.isNumber("4.")); // true
// System.out.println(validator.isNumber("-.9")); // true
// System.out.println(validator.isNumber("2e10")); // true
// System.out.println(validator.isNumber("-90E3")); // true
// System.out.println(validator.isNumber("3e+7")); // true
// System.out.println(validator.isNumber("+6e-1")); // true
// System.out.println(validator.isNumber("53.5e93")); // true
// System.out.println(validator.isNumber("-123.456e789")); // true

// // Invalid test cases
// System.out.println(validator.isNumber("abc")); // false
// System.out.println(validator.isNumber("1a")); // false
// System.out.println(validator.isNumber("1e")); // false
// System.out.println(validator.isNumber("e3")); // false
// System.out.println(validator.isNumber("99e2.5")); // false
// System.out.println(validator.isNumber("--6")); // false
// System.out.println(validator.isNumber("-+3")); // false
// System.out.println(validator.isNumber("95a54e53")); // false
// }
// }
// ```

// ### Explanation:

// 1. **Trim**: The string is first trimmed to remove any leading or trailing
// whitespace.
// 2. **Flags**:
// - `hasNum`: Keeps track of whether there is at least one digit.
// - `hasDot`: Ensures there is only one decimal point.
// - `hasExp`: Ensures there is only one exponent (`'e'` or `'E'`) and digits
// follow it.
// 3. **Character Checks**:
// - If the character is a digit, set `hasNum` to `true`.
// - If it's a decimal point, ensure it hasn't been seen before and there's no
// exponent.
// - If it's an exponent (`'e'` or `'E'`), ensure it hasn't been seen before and
// there is a number before it.
// - If it's a sign (`'+'` or `'-'`), ensure it's either the first character or
// immediately follows an exponent.
// - Any other character makes the string invalid.
// 4. **Final Validation**: After parsing the string, the string is valid only
// if there was at least one digit (`hasNum` is `true`).

// ### Time Complexity:
// - **O(n)** where `n` is the length of the string `s`. Each character is
// processed once.

// ### Space Complexity:
// - **O(1)** since only a few boolean flags are used to track the state of the
// string.