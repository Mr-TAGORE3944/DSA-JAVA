public class isSubsequence {
    




    public static boolean isSubsequenceString(String s , String t){
        int n = s.length();
        int m = t.length();

        boolean[][] dp = new boolean[n+1][m+1];

        // initialzation 
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = false;
        }
        for(int j = 0 ; j <= m ; j++){
            dp[0][j] = true;
        }

        for(int i = 1 ; i <n+1 ; i++){
            for(int j = 1 ; j <m +1 ; j++){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] =  dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        System.out.println(isSubsequenceString("ahbgdc", "abc"));
    }
}
