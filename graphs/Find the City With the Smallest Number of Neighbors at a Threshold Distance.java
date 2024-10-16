import java.util.Arrays;

public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix
        int[][] dist = new int[n][n];
        
        // Fill the distance matrix with large values, except for self-distances (i to i) which are 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;  // Distance from a city to itself is 0
        }
        
        // Set the distances for the given edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        
        // Apply Floyd-Warshall to find the shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Find the city with the smallest number of neighbors within the threshold distance
        int minReachableCities = n;
        int resultCity = -1;
        
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            
            // Update the result city based on the minimum reachable cities count
            if (reachableCities < minReachableCities || (reachableCities == minReachableCities && i > resultCity)) {
                minReachableCities = reachableCities;
                resultCity = i;
            }
        }
        
        return resultCity;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] edges = {
            {0, 1, 4}, {0, 2, 8}, {1, 2, 2}, {1, 3, 6}, {2, 3, 3}
        };
        int n = 4;
        int distanceThreshold = 6;
        
        int result = solution.findTheCity(n, edges, distanceThreshold);
        System.out.println("City with the smallest number of neighbors: " + result);  // Output: 3
    }
}
