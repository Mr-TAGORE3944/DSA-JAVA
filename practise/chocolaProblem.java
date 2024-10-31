package practise;

import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;

public class chocolaProblem {

    public static int find(Integer[] costHr, Integer[] costVr) {
        Arrays.sort(costHr, Collections.reverseOrder());
        Arrays.sort(costVr, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1;
        int vp = 1;

        int cost = 0;
        while (h < costHr.length && v < costVr.length) {
            if (costHr[h] < costVr[v]) {
                cost += costVr[v] * hp;
                vp++;
                v++;
            } else {
                cost += costHr[h] * vp;
                hp++;
                h++;
            }
        }

        while (h < costHr.length) {
            cost += costHr[h] * vp;
            hp++;
            h++;
        }

        while (v < costVr.length) {
            cost += costVr[v] * hp;
            vp++;
            v++;
        }

        return cost;
    }

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costver = { 2, 1, 3, 1, 4 };
        Integer[] costhr = { 4, 1, 2 };
        System.out.println(find(costhr, costver));

        Arrays.sort(costhr, Collections.reverseOrder());
        Arrays.sort(costhr, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int amount = 0;

        while (h < costhr.length && v < costver.length) {
            if (costhr[h] < costver[v]) {
                amount += costver[v] * hp;
                vp++;
                v++;
            } else {
                amount += costhr[h] * vp;
                hp++;
                h++;
            }
        }

        // now cut the remaining cuts
        while (h < costhr.length) {
            amount += costhr[h] * vp;
            hp++;
            h++;
        }

        while (v < costver.length) {
            amount += costver[v] * hp;
            vp++;
            v++;
        }

        System.out.println(amount);
    }
}
