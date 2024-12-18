package practise.Greedy;

import java.util.*;

public class maxLengthChainPair {

    public static void main(String[] args) {
        int[][] pair = { { 5, 24 }, { 39, 60 }, { 5, 28 } };
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));
        int chainLength = 1;
        int last = pair[0][1];
        for (int i = 1; i < pair.length; i++) {
            if (last < pair[i][0]) {
                chainLength = chainLength + 1;
                last = pair[i][1];
            }
        }

        System.out.println(chainLength);
    }
}
