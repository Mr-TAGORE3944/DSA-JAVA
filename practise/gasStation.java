package practise;

public class gasStation {

    public static int find(int[] gas, int cost[]) {
        int n = gas.length;
        int current = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];

            if (current < 0) {
                current = 0;
                start++;
            }
        }

        return total >= 0 ? start : -1;
    }

    public static int find2(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int current = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {

            total += gas[i] - cost[i];
            current += gas[i] - cost[i];

            if (current < 0) {
                current = 0;
                start++;
            }
        }

        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(find(gas, cost));
        System.out.println(find2(gas, cost));
    }
}
