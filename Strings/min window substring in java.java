import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Create a frequency map for the characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track the sliding window
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0;

        // Create a frequency map for the sliding window
        Map<Character, Integer> windowMap = new HashMap<>();

        // Slide the window over s
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If the current character is part of t and its frequency in the window
            // is less than or equal to the required frequency, increase the count
            if (targetMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() <= targetMap.get(rightChar).intValue()) {
                count++;
            }

            // Shrink the window from the left when all characters of t are found
            while (count == t.length()) {
                // Update the minimum window size if a smaller one is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Shrink the window by moving the left pointer
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If the character at the left pointer is part of t and its frequency
                // in the window becomes less than the required frequency, decrease the count
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    count--;
                }

                left++;
            }

            right++;
        }

        // If no valid window is found, return an empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring solution = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + solution.minWindow(s, t));
    }
}
