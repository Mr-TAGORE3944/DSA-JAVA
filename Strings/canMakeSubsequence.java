class Solution {
    public boolean canMakeSubsequence(String source, String target) {
        int sourceIndex = 0;
        int targetIndex = 0;

        while (sourceIndex < source.length() && targetIndex < target.length()) {
            char sourceChar = source.charAt(sourceIndex);
            char targetChar = target.charAt(targetIndex);

            // Check if sourceChar matches targetChar or can be reached via cyclic increment
            if (sourceChar == targetChar ||
                    (sourceChar - 'a' + 1) % 26 + 'a' == targetChar) {
                targetIndex++; // Move to the next character in target
            }

            sourceIndex++; // Always move to the next character in source
        }

        // If we matched all characters of target, return true
        return targetIndex == target.length();
    }
}
