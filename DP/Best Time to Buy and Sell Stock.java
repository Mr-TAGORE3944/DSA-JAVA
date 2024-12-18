public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Traverse the prices array
        for (int price : prices) {
            // Update minPrice if a new lower price is found
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if selling at the current price
            else {
                int profit = price - minPrice;
                // Update maxProfit if the new profit is greater
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Maximum Profit: " + solution.maxProfit(prices)); // Output: 5
    }
}
