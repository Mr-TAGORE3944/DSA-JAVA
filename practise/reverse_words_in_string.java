package practise;
import java.util.*;
public class reverse_words_in_string {

    public static String reverseWords(String s) {
        // Trim the input to remove leading and trailing spaces
        s = s.trim();

        // Split the string by spaces into words
        String[] words = s.split("\\s+");

        // Initialize a StringBuilder to store the result
        StringBuilder reversed = new StringBuilder();

        // Iterate over the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // Add a space between words
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "  Hello   World  ";
        System.out.println(reverseWords(input)); // Output: "World Hello"
    }
}
