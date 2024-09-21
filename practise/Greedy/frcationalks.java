package practise.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class frcationalks {
    

    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] wt = {10 , 20 , 30};
        int W = 50;
        double ratio[][] = new double[val.length][2];
        for(int  i = 0 ; i < val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)val[i] / (double)wt[i];
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));
        int cap = W;
        int finale = 0;

        for(int i = val.length-1 ; i >=0 ; i--){
            int idx = (int) ratio[i][0];
            if(cap >= wt[i]){
                finale += val[idx];
                cap -= wt[idx];
            }else {
                finale += cap * ratio[i][1];
                cap = 0;
                break;
            }
        }


        System.out.println(finale);
    }
}
