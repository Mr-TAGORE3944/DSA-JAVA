package practise;

import java.util.HashMap;

public class solution {

    public static void main(String[] args) {
        String s = "oppo";
        String t = "oppo";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                System.out.println(false);
                return;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            if (map.get(t.charAt(i)) == 0) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
