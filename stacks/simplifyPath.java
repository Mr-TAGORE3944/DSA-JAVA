package stacks;

import java.util.Stack;

public class simplifyPath {

    public static void main(String[] args) {
        String str = "/home/";

        Stack<String> st = new Stack<>();

        String[] comps = str.split("/");

        for (String com : comps) {
            if (com.equals("") || com.equals(".")) {
                continue;
            } else if (com.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(com);
            }
        }

        StringBuilder stb = new StringBuilder();
        for (String com : st) {
            stb.append("/").append(com);
        }

        System.out.println(stb);
    }
}
