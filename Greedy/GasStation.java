public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            // If we run out of gas, reset the starting station
            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }

        // If totalTank is negative, completing the circuit is impossible
        return totalTank >= 0 ? startingStation : -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int startingStation = gasStation.canCompleteCircuit(gas, cost);

        if (startingStation != -1) {
            System.out.println("The car can complete the circuit starting at station: " + startingStation);
        } else {
            System.out.println("It is impossible to complete the circuit.");
        }
    }
}
