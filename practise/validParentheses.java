package practise;

import java.util.Stack;

public class validParentheses {

    public static boolean Dup(String str ){
        int n = str.length();
        int cnt = 0 ;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                cnt = 0;
                while (st.peek() != '(') {
                    st.pop();
                    cnt++;
                }
                if(cnt< 1){
                    return true;
                } else {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }


        return false;
    }
    

    public static boolean CheckValidParentheses(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if((ch == ')' && st.peek() == '(')
                || (ch == '}' && st.peek() == '{')
                || (ch == ']' && st.peek() == '[')
                ){
                    st.pop();
                }else {
                    return false;
                }
            }
        }

        return true;
    }
public static void main(String[] args) {
    String str = "(){}[]";
    System.out.println(CheckValidParentheses(str));
}
}
