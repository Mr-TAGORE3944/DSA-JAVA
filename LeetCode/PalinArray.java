package LeetCode;

import java.util.*;

public class PalinArray {
    public static void main(String[] args) {
        String[] words = { "cd", "ef", "a" };
        int n = words.length;
        int[] cnt = new int[26];
        List<Integer> sizes = new ArrayList<>();
        for (String i : words) {
            sizes.add(i.length());
            char[] chars = i.toCharArray();
            for (char j : chars) {
                cnt[j - 'a']++;
            }
        }
        System.out.println(Arrays.toString(cnt));
        Collections.sort(sizes);
        System.out.println(sizes);
        int even = 0, odd = 0;
        for (int i = 0; i < 26; i++) {
            even += (cnt[i] / 2) * 2;
            odd += cnt[i] % 2;
        }
        System.out.println(even + " " + odd);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sz = sizes.get(i);
            if (sz % 2 == 0) {
                if (sz > even)
                    break;
                even -= sz;
            } else {
                if (sz - 1 >= even)
                    break;
                even -= sz - 1;
                if (odd == 0) {
                    even -= 2;
                    odd += 2;
                }
                odd--;
            }
            ans++;
        }
        System.out.println(ans);

    }
}
