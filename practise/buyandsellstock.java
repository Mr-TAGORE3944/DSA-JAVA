package practise;

public class buyandsellstock {



    public static int find(int[] prices){
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if (price < minPrice) {
                minPrice = price;
            }

            else{
                int profit = price - minPrice;

                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }
    

    public static int maxprofit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if (price < minPrice) {
                minPrice = price;
            }

            else{
                int profit = price - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        
        int[] arr = {7,1,5,3,6,4};

        System.out.println(find(arr));
        System.out.println(maxprofit(arr));

    }
}
