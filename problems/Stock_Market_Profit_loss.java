package problems;

public class Stock_Market_Profit_loss {


    static int FindStock(int[] prices){
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0 ; i < n ; i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
    

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6,  4};
        System.out.println(FindStock(prices));
    }
}
