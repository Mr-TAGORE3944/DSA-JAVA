class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, result, "", 0, 0);
        return result;
    }

    public static boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;  // No leading zeros unless the segment is exactly "0"
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

    public void backtrack(String s, List<String> result, String current, int index, int segment) {
        // Base case: If we've built 4 segments and used up all characters, it's valid
        if (segment == 4 && index == s.length()) {
            result.add(current);
            return;
        }

        // If we've made 4 segments or reached the end of the string, stop
        if (segment == 4 || index >= s.length()) {
            return;
        }

        // Try segments of length 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;  // Avoid slicing beyond the end of the string
            }
            String part = s.substring(index, index + len);
            if (isValid(part)) {
                // Recursively build the next segment
                backtrack(s, result, current + part + (segment < 3 ? "." : ""), index + len, segment + 1);
            }
        }
    }
}
