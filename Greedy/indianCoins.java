// package practise.Greedy;

import java.util.*;

public class indianCoins {

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        int amount = 590;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    arr.add(coins[i]);
                    count = count + 1;
                    amount -= coins[i];
                }
            }
        }

        System.out.println(count);
        while (!arr.isEmpty()) {
            System.out.print(arr.remove(amount) + " ");
        }
    }
}
