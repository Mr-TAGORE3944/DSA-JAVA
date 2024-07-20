public class subsequences_arrays {
    
    static void printSSQ(String s , String curr){
        if(s.length() == 0){
            System.out.println(curr);
            return;
        }

        char c = s.charAt(0);


        printSSQ(s.substring(1), curr + c);
        printSSQ(s.substring(1), curr);
    }


    public static void main(String[] args) {
        String s = "abc";

        printSSQ(s, "");



    }
}
