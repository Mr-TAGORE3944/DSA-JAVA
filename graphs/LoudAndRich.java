import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {

    // Method to find the quietest person for each person
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        // Build the graph (adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // For each pair (a, b) where a is richer than b, create a directed edge b -> a
        for (int[] pair : richer) {
            graph.get(pair[1]).add(pair[0]);
        }

        // Initialize the result array, where each index starts as -1 (unprocessed)
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Perform DFS for each person
        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, result);
        }

        return result;
    }

    // DFS method to find the quietest person in the richer chain of the current
    // person
    private int dfs(int person, List<List<Integer>> graph, int[] quiet, int[] result) {
        // If already processed, return the cached result
        if (result[person] != -1) {
            return result[person];
        }

        // The quietest person is initially the person themselves
        result[person] = person;

        // Explore all richer people and find the quietest among them
        for (int richerPerson : graph.get(person)) {
            int candidate = dfs(richerPerson, graph, quiet, result);
            // Compare quietness, and update if a quieter person is found
            if (quiet[candidate] < quiet[result[person]]) {
                result[person] = candidate;
            }
        }

        return result[person];
    }

    // Main method for testing
    public static void main(String[] args) {
        LoudAndRich solution = new LoudAndRich();

        // Test case
        int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
        int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };

        int[] result = solution.loudAndRich(richer, quiet);

        // Output the result
        System.out.println(Arrays.toString(result));
    }
}
