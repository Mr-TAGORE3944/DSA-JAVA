import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    // Method to find all paths from source (0) to target (n-1)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, currentPath, result);
        return result;
    }

    // Depth First Search (DFS) to explore all paths
    private void dfs(int[][] graph, int node, int target, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(node); // Add the current node to the path

        // If the current node is the target, add the path to the result
        if (node == target) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Explore each neighbor (connected node) of the current node
            for (int neighbor : graph[node]) {
                dfs(graph, neighbor, target, currentPath, result);
            }
        }

        // Backtrack to explore another path
        currentPath.remove(currentPath.size() - 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        AllPathsSourceTarget solution = new AllPathsSourceTarget();

        // Example graph: adjacency list representation
        int[][] graph = {
                { 1, 2 }, // Node 0 -> Nodes 1, 2
                { 3 }, // Node 1 -> Node 3
                { 3 }, // Node 2 -> Node 3
                {} // Node 3 -> No outgoing edges (target node)
        };

        // Find all paths from source (0) to target (3)
        List<List<Integer>> paths = solution.allPathsSourceTarget(graph);

        // Print the result
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
