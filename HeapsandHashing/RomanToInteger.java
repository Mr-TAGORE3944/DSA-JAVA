import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = romanValues.get(s.charAt(i));
            // Check if this is the last character or if we need to subtract
            if (i < length - 1 && currentVal < romanValues.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();
        String roman = "MCMXCIV"; // Should return 1994
        int result = converter.romanToInt(roman);
        System.out.println("The integer value of " + roman + " is: " + result);
    }
}
