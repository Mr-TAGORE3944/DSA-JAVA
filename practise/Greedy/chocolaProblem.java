package practise.Greedy;
import java.util.*;

public class chocolaProblem {
    

    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costver = {2,1,3,1,4};
        Integer[] costhr = {4,1,2};

        Arrays.sort(costver , Collections.reverseOrder());
        Arrays.sort(costhr , Collections.reverseOrder());
        int h = 0 , v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costhr.length && v < costver.length) {
            if(costver[v] < costhr[h]){
                cost += costhr[h] * vp;
                hp++;
                h++;
            }else {
                cost += costver[v] * hp;
                vp++;
                v++;
            }
        }

        while (h < costhr.length) {
            cost += costhr[h] * vp;
            h++;
            hp++;
        }

        while (v < costver.length) {
            cost += costver[v] * hp;
            vp++;
            v++;
        }

        System.out.println(cost);
        
    }
}
