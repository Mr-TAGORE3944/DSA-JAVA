public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        // Two pointers approach: start from the beginning and end of the string
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move the left pointer if the character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move the right pointer if the character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare the characters after normalizing to lowercase
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        
        // Test cases
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + solution.isPalindrome(test1)); // true

        String test2 = "race a car";
        System.out.println("Is palindrome: " + solution.isPalindrome(test2)); // false
    }
}
