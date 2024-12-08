class Solution {
    public boolean canChange(String start, String target) {
        // Remove underscores and check if the sequences of L and R match
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int i = 0, j = 0; // Pointers for start and target

        while (i < start.length() && j < target.length()) {
            // Skip underscores in start and target
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }

            // If both i and j reach the end, strings are valid
            if (i == start.length() && j == target.length()) {
                return true;
            }

            // If one reaches the end but not the other, invalid
            if (i == start.length() || j == target.length()) {
                return false;
            }

            // Check the constraints for 'L' and 'R'
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false; // 'L' can only move left
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false; // 'R' can only move right
            }

            // Move both pointers
            i++;
            j++;
        }

        return true;
    }
}
