
public class TrieImplementation {
    public static class Node {
        Node[] children;
        boolean eow; // end of word

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            if (i == word.length() - 1 && !curr.children[idx].eow)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }

    public static void WordBreak(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null)
                return;
            String s = "";
            if (curr.children[idx].eow == true) {
                System.out.println(s);
                s = "";
            } else {
                s += word.charAt(i);
            }
            curr = curr.children[idx];
        }
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0)
            return true;
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String lastPart = key.substring(i);
            if (search(firstPart) && wordBreak(lastPart))
                return true;
        }
        return false;
    }

    public static boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }

        return true;
    }

    public static int countNodes(Node root) {
        Node curr = root;
        if (curr == null)
            return 0;
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null)
                count += countNodes(root.children[i]);
        }

        return count + 1;
    }

    public static void helper() {
        // String s = "ababa";
        // for(int i = 0 ; i < s.length() ; i++){
        // insert(s.substring(i));
        // }
        // System.out.println(countNodes(root));

        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null)
            return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

        helper();
    }
}
