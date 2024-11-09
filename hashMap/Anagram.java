package hashMap;

import java.util.HashMap;

public class Anagram {

    static HashMap<Character, Integer> makeFreq(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                int feq = mp.get(ch);
                mp.put(ch, feq + 1);
            }
        }
        return mp;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> m1 = makeFreq(s);
        HashMap<Character, Integer> m2 = makeFreq(t);
        return m1.equals(m2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> mp = makeFreq(s);
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (!mp.containsKey(ch))
                return false;
            mp.put(ch, mp.get(ch) - 1);
            if (mp.get(ch) == 0)
                mp.remove(ch);
        }
        return mp.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("oppo", "oppot"));
    }
}
