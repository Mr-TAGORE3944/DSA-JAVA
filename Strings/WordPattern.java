import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // If pattern and words length do not match, return false
        if (pattern.length() != words.length) {
            return false;
        }

        // HashMap to store character-to-word mapping
        Map<Character, String> charToWord = new HashMap<>();
        // HashMap to store word-to-character mapping
        Map<String, Character> wordToChar = new HashMap<>();

        // Loop through each character in pattern and corresponding word
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check if there's a conflict in character-to-word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check if there's a conflict in word-to-character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        // If we pass all checks, the pattern matches the word structure
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog")); // Output: true
        System.out.println(wp.wordPattern("abba", "dog cat cat fish")); // Output: false
        System.out.println(wp.wordPattern("aaaa", "dog dog dog dog")); // Output: true
        System.out.println(wp.wordPattern("abba", "dog dog dog dog")); // Output: false
    }
}
