public class FirstOccurrenceTwoPointer {

    public static int firstOccurrence(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        // If needle is an empty string, return 0
        if (n == 0) {
            return 0;
        }

        // Loop through the haystack where the needle can fit
        for (int i = 0; i <= m - n; i++) {
            // Initialize a pointer to check if needle matches at position i
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If j reaches the end of needle, we found a match
            if (j == n) {
                return i;
            }
        }

        // If no match is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int index = firstOccurrence(haystack, needle);
        System.out.println("The index of the first occurrence is: " + index); // Output: 2
    }
}
