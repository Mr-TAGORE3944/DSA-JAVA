package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            System.out.println(Arrays.toString(charArray));
            Arrays.sort(charArray);
            System.out.println(Arrays.toString(charArray));
            // Sort the string's characters
            String key = new String(charArray);
            System.out.println(key);
            // Use the sorted string as the key
            // Add the original string to the corresponding list in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = ga.groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
