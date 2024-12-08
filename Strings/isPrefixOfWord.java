class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Iterate over each word
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with the searchWord
            if (words[i].startsWith(searchWord)) {
                return i + 1; // Return 1-based index
            }
        }

        // If no word starts with the searchWord, return -1
        return -1;
    }
}
