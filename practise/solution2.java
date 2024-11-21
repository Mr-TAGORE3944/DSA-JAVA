package practise;

import java.util.*;

public class solution2 {

    // public static void main(String[] args) {

    // String str = "abcabcbb";
    // int left = 0;
    // int right = 0;
    // int maxLen = 0;
    // HashSet<Character> set = new HashSet<>();
    // while (right < str.length()) {
    // if (!set.contains(str.charAt(right))) {
    // set.add(str.charAt(right));
    // right++;
    // maxLen = Math.max(right - left, maxLen);
    // } else {
    // set.remove(str.charAt(left));
    // left++;
    // }
    // }

    // System.out.println(maxLen);
    // }

    // public static void main(String[] args) {
    // String str = "(()))()()(";
    // Stack<Integer> st = new Stack<>();
    // int maxLen = 0;
    // st.push(-1);
    // for (int i = 0; i < str.length(); i++) {
    // char ch = str.charAt(i);
    // if (ch == '(') {
    // st.push(i);
    // } else {
    // st.pop();
    // if (st.isEmpty()) {
    // st.push(i);
    // } else {
    // maxLen = Math.max(maxLen, i - st.peek());
    // }
    // }
    // }

    // System.out.println(maxLen);
    // }

    // public static void main(String[] args) {
    // String s1 = "100";
    // String s2 = "101";

    // int n = s1.length();
    // int m = s2.length();
    // int result[] = new int[n + m];

    // for (int i = n - 1; i >= 0; i--) {
    // for (int j = m - 1; j >= 0; j--) {
    // int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
    // int sum = mul + result[i + j + 1];
    // result[i + j + 1] = sum % 10;
    // result[i + j] += sum / 10;
    // }
    // }

    // StringBuilder stb = new StringBuilder();
    // for (int num : result) {
    // if (!(stb.length() == 0 && num == 0)) {
    // stb.append(num);
    // }
    // }

    // System.out.println(stb.toString());
    // }

    // public static void back(String input) {
    // List<List<String>> result = new ArrayList<>();
    // back(input, 0, new ArrayList<>(), result);
    // System.out.println(result);

    // }

    // public static void back(String s, int start, List<String> current,
    // List<List<String>> result) {
    // if (s.length() == start) {
    // result.add(new ArrayList<>(current));
    // return;
    // }

    // for (int end = start; end < s.length(); end++) {
    // if (isPalin(s, start, end)) {
    // current.add(s.substring(start, end + 1));
    // back(s, end + 1, current, result);
    // current.remove(current.size() - 1);
    // }
    // }

    // return;
    // }

    // public static boolean isPalin(String s, int left, int right) {
    // while (left < right) {
    // if (s.charAt(left) != s.charAt(right)) {
    // return false;
    // }
    // left++;
    // right--;
    // }
    // return true;
    // }

    // public static void main(String[] args) {
    // String str = "aab";
    // back(str);
    // }

}
