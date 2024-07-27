package stacks;

import java.util.Stack;

public class Prefix_Sum {
    
    static String findPrefixSum(String str){
        Stack <String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii <= 57 && ascii >= 48){
                String s = "" + ch;
                val.push(s);
            }
            else if(op.size() == 0 || ch == '(' || op.peek() == '(') op.push(ch);
            else if(ch == ')'){
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    val.push(o+v1+v2);
                }
                op.pop();
            }
            else {
                if(ch == '+' || ch == '-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    val.push(o+v1+v2);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                    val.push(o+v1+v2);
                        op.push(ch);
                    } else 
                        op.push(ch);
                }
                
            }
            while (val.size() > 1) {
                String v2 = val.pop();
                String v1 = val.pop();
                char o = op.pop();
                    val.push(o+v1+v2);
            }
            }
            String res = val.pop();
        return res;
    }
  

    public static void main(String[] args) {
        String res = findPrefixSum("9-(5+3)*4/6");
        System.out.println(res);
        
    }
    
}
