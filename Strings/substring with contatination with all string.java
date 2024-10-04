import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int numWords = words.length;
        int windowSize = wordLength * numWords;
        int sLength = s.length();

        // Build a frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate over all possible starting points in the word-length range
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;  // Number of valid words matched in the current window

            while (right + wordLength <= sLength) {
                // Get a word from the right side of the window
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // Check if the word is in the dictionary
                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    // If there are too many occurrences of this word, slide the window
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // If we have matched all words, record the starting index
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // If the word is not part of the valid words, reset the window
                    seenWords.clear();
                    count = 0;
                    left = right;  // Move left pointer to the right
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = solution.findSubstring(s, words);
        System.out.println(result);  // Output: [0, 9]
    }
}
