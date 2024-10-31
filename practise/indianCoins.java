package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class indianCoins {

    public static void main(String[] args) {
        Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Collections.reverseOrder());
        int count = 0;
        int amount = 590;
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {

                while (amount >= coins[i]) {
                    arr.add(coins[i]);
                    count++;
                    amount -= coins[i];
                }
            }
        }

        System.out.println(count);
        System.out.println(arr);
    }
}
