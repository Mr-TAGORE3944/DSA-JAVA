package practise;

public class distictSubsequence {


    public static int find(String s , String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        // initailzation 
        // an empty string t is always a subsequence of s;
        for(int i = 0 ; i < n+1 ;i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n +1 ; i++){
            for(int j = 1 ; j < m +1 ; j++){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // include in string
                    int include = dp[i-1][j-1];
                    // not include 
                    int ninclude = dp[i-1][j];

                    // add both to the op array
                    dp[i][j] = include + ninclude;
                }else{
                    // the char at present is not equal s0 we cant incude in the dp
                    dp[i][j] = dp[i-1][j];
                }
            }


        }

        return dp[n][m];
    }
    

    public static int find2(String s , String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        // initialization 
        for(int i = 0 ; i < n +1 ; i++){
            dp[i][0] = 1;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ;j <= m ; j++){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // include 
                    int include = dp[i-1][j-1];
                    // not include 
                    int NotInclude = dp[i-1][j];
                    
                    dp[i][j] = include +  NotInclude;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        String str1 = "rabbit";
        String str2 = "rabbbit";

        System.out.println(find(str2, str1));
        System.out.println(find2(str2, str1));
        }
}
