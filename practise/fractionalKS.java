package practise;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKS {

    public static int find(int[] val, int[] wt, int W) {
        int n = val.length;

        double[][] ratio = new double[n][2];
        for (int i = 0; i < n; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / (double) wt[i];
        }

        int finale = 0;
        int cap = W;

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for (int i = n - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (cap >= wt[idx]) {
                finale += val[idx];
                cap -= wt[idx];
            } else {
                finale += cap * ratio[i][1];
                cap = 0;
                break;
            }
        }

        return (int) finale;
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int[] val2 = { 60, 100, 120 };
        int[] wt2 = { 10, 20, 30 };

        int W = 50;

        double[][] ratio = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // store index of item
            ratio[i][1] = (double) val[i] / (double) wt[i]; // store value-to-weight ratio
        }

        // Sort by ratio in descending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> -o[1]));

        int cap = W;
        double finale = 0; // Use double for fractional result

        for (int i = 0; i < val.length; i++) {
            int idx = (int) ratio[i][0];
            if (cap >= wt[idx]) {
                finale += val[idx];
                cap -= wt[idx];
            } else {
                finale += cap * ratio[i][1];
                break;
            }
        }

        System.out.println(finale);
        System.out.println(find(val2, wt2, W));
    }
}
