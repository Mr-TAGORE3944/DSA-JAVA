class Solution {
    public long minimumSteps(String s) {
        int left = 0;
        int right = s.length() - 1;
        long swaps = 0; // Count of actual swaps

        // Convert the string to a char array once for efficient swapping
        char[] ch = s.toCharArray();

        while (left < right) {

            // Move left pointer to the right until a '0' is found
            while (left < right && ch[left] == '1') {
                left++;
            }

            // Move right pointer to the left until a '1' is found
            while (left < right && ch[right] == '0') {
                right--;
            }

            // If a swap is possible
            if (left < right) {
                // Swap the '0' at left with the '1' at right
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                // Increment swap count and update pointers
                swaps++;
                left++;
                right--;
            }
        }

        return swaps;
    }
}
