import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String p, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] arr = s.split(" ");
        if (arr.length != p.length())
            return false;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            String word = arr[i];

            // Check character-to-word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check word-to-character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
