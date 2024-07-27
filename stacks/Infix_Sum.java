package stacks;

import java.util.Stack;

public class Infix_Sum {


    static int findInFixSum(String str){
        Stack <Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii <= 57 && ascii >= 48) val.push(ascii- 48);
            else if(op.size() == 0 || ch == '(' || op.peek() == '(') op.push(ch);
            else if(ch == ')'){
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1 + v2);
                    if(op.peek() == '-') val.push(v1 - v2);
                    if(op.peek() == '*') val.push(v1 * v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                }
                op.pop();
            }
            else {
                if(ch == '+' || ch == '-'){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1 + v2);
                    if(op.peek() == '-') val.push(v1 - v2);
                    if(op.peek() == '*') val.push(v1 * v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        int v2 = val.pop();
                        int v1 = val.pop();
                    if(op.peek() == '*') val.push(v1 * v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    } else 
                        op.push(ch);
                }
                
            }
            while (val.size() > 1) {
                int v2 = val.pop();
                int v1 = val.pop();
                    if(op.peek() == '+') val.push(v1 + v2);
                    if(op.peek() == '-') val.push(v1 - v2);
                    if(op.peek() == '*') val.push(v1 * v2);
                    if(op.peek() == '/') val.push(v1 / v2);
                    op.pop();
            }
            }
        return val.peek();
    }
    public static void main(String[] args) {
        
        System.out.println(findInFixSum("9-(5+3)*4/6"));
        // 4 + 2 = 6


    }
    
}
