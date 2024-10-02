import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        // Base case: If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Explore all possible partitions by trying every possible end index
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // If the substring s[start:end+1] is a palindrome, add it to the current partition
                currentList.add(s.substring(start, end + 1));
                // Recur to partition the remaining substring
                backtrack(s, end + 1, currentList, result);
                // Backtrack: remove the last added palindrome to try other partitions
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    // Helper function to check if a substring s[left:right+1] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String input = "aab";
        List<List<String>> partitions = solution.partition(input);
        System.out.println("Palindrome partitions: " + partitions);
    }
}
