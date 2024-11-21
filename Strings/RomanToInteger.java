import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        // Step 1: Define a map of Roman numeral symbols and their integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Step 2: Initialize result and previous value
        int result = 0;
        int prevValue = 0;

        // Step 3: Loop through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Get the integer value of the current Roman numeral
            int currentValue = romanMap.get(s.charAt(i));

            // Step 4: Check if this value should be added or subtracted
            if (currentValue >= prevValue) {
                // Add the value to the result
                result += currentValue;
            } else {
                // Subtract the value from the result
                result -= currentValue;
            }

            // Update previous value
            prevValue = currentValue;
        }

        // Step 5: Return the final result
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(romanToInt("III"));    // 3
        System.out.println(romanToInt("LVIII"));  // 58
        System.out.println(romanToInt("MCMXCIV"));// 1994
        System.out.println(romanToInt("MMXXIII"));// 2023
        System.out.println(romanToInt("MMMCMXCIX")); // 3999
    }
}
