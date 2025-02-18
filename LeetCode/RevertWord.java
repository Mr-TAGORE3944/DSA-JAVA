package LeetCode;

public class RevertWord {

    public static void main(String[] args) {
        String str = "ba";
        int k = 1; // Length of substring
        int cnt = 0; // Operation counter
        String oir = str; // Original string
        int n = oir.length();
        // Loop until the word cannot be split further
        for (int i = 1; i < oir.length(); i++) {
            if (k * i > n) {
                break;
            }
            String word = str.substring(Math.max(k - 1, 1));
            str = word;
            System.out.println(word);
            cnt++;
            if (oir.startsWith(word)) {
                break;
            }
        }
        // Output the number of operations
        System.out.println(cnt);
    }
}
