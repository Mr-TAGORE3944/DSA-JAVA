





public class longestPalindromicSubstring {



    public static int expand_around_center(String str , int left , int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;

    }



    public static String longestSubsequence(String str){
        if(str.length() == 0 || str == null) return "";
        int start = 0, end = 0;

        for(int i = 0 ; i < str.length() ; i++){
            int len1 = expand_around_center(str , i , i); // for even 
            int len2 = expand_around_center(str , i , i +1 ); // for odd 
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len - 1) /2;
                end = i + (len) / 2;
            } 
        }
            return str.substring(start , end + 1);
    }
    

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestSubsequence(str));
        System.out.println(Ans(str));
    }

    // practise 

    public static String Ans(String str){
        if (str == null ) {
            return "";
        }

        int start = 0 ;
        int end = 0;

        for(int i = 0 ; i < str.length() ; i++){
            int len1 = ansUtil(str , i , i); // for odd strings
            int len2 = ansUtil(str , i ,i +1); // for even strings

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len/2;
            }
        }
        return str.substring(start , end+1
        );
    }


    public static int ansUtil(String str , int left , int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;

    }
}
