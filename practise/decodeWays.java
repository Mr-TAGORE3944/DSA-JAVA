package practise;

public class decodeWays {


    public static int decode(String str){
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = str.charAt(0) == 0? 0 : 1;
        for(int i = 2 ; i <= n ; i++){
            if (str.charAt(i-1) != 0) {
                dp[i]  += dp[i-1];
            }
            
                int twoDigit = Integer.parseInt(str.substring(i-2 , i));
                if ( twoDigit <= 26 && twoDigit >= 10) {
                    dp[i] += dp[i-2];
                }
            
        }

        return dp[n];

    }
    


    public static int decode2(String str){
        int n = str.length();

        int[] dp = new int[n+1];
        // dp of 0 is decoded as 0 because the 0 is decode only as zero once
        dp[0] = 1;
        // the dp of 1 is if it zero then it is decoded as zero or 1 as 1
        // because the 00 is only decoded as 0 only once 
        // but the 01 is decoded as 1 itself so it can be decoded as 1
        dp[1] = str.charAt(0) == 0 ? 0 : 1;

        for(int i = 2 ; i <= n ; i++){
            if (str.charAt(i-1) != 0) {
                dp[i] += dp[i-1];
            }

            int twoDigit = Integer.parseInt(str.substring(i-2 ,i));
            if (twoDigit <= 26 && twoDigit >= 10) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }



    public static void main(String[] args) {
        String str = "226";
        System.out.println(decode(str));
        System.out.println(decode2(str));

    }
}
