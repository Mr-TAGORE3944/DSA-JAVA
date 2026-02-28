class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int i = 1;
        int price = prices[0];
        while( i < prices.size()){
            if(prices[i] < price){
                price = prices[i];
            }
            profit = max(profit , prices[i] - price);
            i++;
        }

        return profit;
    }
};