package stacks;

import java.util.Stack;

public class prefix_to_infix {
    


    public static void main(String[] args) {
        

      String str = "-9/*+5346";
      Stack<String> val = new Stack<>();
      for(int i = str.length() -1 ; i>=0 ; i--){
        char ch = str.charAt(i);
        int ascii  = (int) ch;
        if(ascii <= 57 && ascii >= 48){
            val.push(ch + "");
        }else {
            String v1 = val.pop();
            String v2 = val.pop();
            char op = ch;
            val.push("(" + v1 + op + v2 + ")");
        }
      }
      System.err.println(val.peek());
     }
}
