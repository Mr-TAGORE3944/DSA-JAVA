package backtracking;

public class printPermutations {

    public static void print(String s , String t)
    {
        if(s.length()<= 0) {
            System.out.println(t);
            return;
        }

        for(int i = 0; i < s.length() ; i++){
            char ch = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            print(left + right , t+ch);
        }
    }

    public static void main(String[] args) {
        
        print("abc", "");

    }
}
