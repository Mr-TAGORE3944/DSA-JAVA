package stacks;

import java.util.Scanner;
import java.util.Stack;

public class correct_braces {

    public static boolean findBraces(String str){
            int n = str.length();
            Stack <Character> st = new Stack<>();
            for(int i = 0 ; i < n ; i++){
                char ch = str.charAt(i);
                if(ch == '('){
                    st.push('(');
                }else{
                    if(st.size() == 0) return false;
                    if(st.peek() == '(') st.pop();
                }
            }
            if(st.size() >0) return false;
            return true;
    }

        public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch =='{' ||ch == '['){
                st.push(ch);
                System.out.println(ch);
            }else {
                if(st.size() == 0) return false;
                System.out.println("str.char  " + ch);
                char c = st.peek();
                System.out.println("st.peek  " + c);
                System.out.println(st.size());
                if(c == '(' && ch == ')' ) st.pop();
                System.out.println(st.size());
                if(c== '{' && ch == '}') st.pop();
                System.out.println(st.size());
                if( c== '[' && ch == ']') st.pop(); 
                System.out.println(st.size());
            }
        }
        if(st.size() == 0) return true;
        return false;
    }
    public static void main(String[] args) {
        

        Stack<String> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coded : ");
        String n = sc.nextLine();
        System.out.println(isValid(n));
        // for(int i = 0 ; i < n.length() ; i++){
        //     if("(".equals(n.charAt(i))){
        //         st.push("(");
        //     } else {
        //         if(st.peek().equals("(")){
        //             st.pop();
        //         }
        //     }
        // }
        // if(st.size() != 0){
        //     System.out.println("Not Correct");
        // } else {
        //     System.out.println("Correct");
        // }

    }
}
