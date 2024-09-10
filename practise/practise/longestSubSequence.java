package practise;

import java.util.HashSet;

/**
 * longestSubSequence
 */
public class longestSubSequence {

    public static int findLength(String str1 , String str2 ){
        HashSet<Character> h =  new HashSet<>();

        for(int i = 0 ; i < str1.length() ; i++){
            h.add(str1.charAt(i));
        }

        int cnt = 0 ;
        for(int i = 0 ; i < str2.length();i++){
            if(h.contains(str2.charAt(i))){
                cnt++;
            }
        }

        return cnt;
    }

    public static int find2(String str1 , String str2 , int n , int m ){
                if( n == 0 || m ==0 ) return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return find2(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1 = find2(str1, str2, n-1, m);
            int ans2 = find2(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int findAdv(String str1 , String str2 , int n , int m  , int[][] dp){
                if( n == 0 || m ==0 ) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = find2(str1, str2, n-1, m-1) + 1;
        }else{
            int ans1 = find2(str1, str2, n-1, m);
            int ans2 = find2(str1, str2, n, m-1);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ade";

        System.out.println(findLength(str1, str2));
        System.out.println(find2(str1, str2, str1.length(), str2.length()));
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 0 ; i < str1.length()+1;i++){
            for(int j = 0 ; j < str2.length()+1;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(findAdv(str1, str2, str1.length(), str2.length(), dp));
    }
}