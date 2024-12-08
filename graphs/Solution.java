import java.util.*;

public class Solution {

    // Main function to find the number of operations to make the network connected
    public int makeConnected(int n, int[][] connections) {
        // If there are less than n-1 edges, it's impossible to connect all computers
        if (connections.length < n - 1) {
            return -1;
        }

        // Union-Find data structure initialization
        int[] parent = new int[n];
        int[] rank = new int[n];

        // Initialize each computer as its own parent (disjoint set)
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Perform union operations for each connection
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            union(parent, rank, u, v);
        }

        // Count the number of connected components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                components++;
            }
        }

        // The number of operations needed is components - 1
        return components - 1;
    }

    // Helper method to find the root of a node with path compression
    private int find(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = find(parent, parent[u]);
        }
        return parent[u];
    }

    // Helper method to union two sets by rank
    private void union(int[] parent, int[] rank, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int n = 4;
        System.out.println(solution.makeConnected(n, connections)); // Output: 1
    }
}
