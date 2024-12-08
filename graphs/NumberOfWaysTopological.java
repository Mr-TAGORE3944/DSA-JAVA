import java.util.*;

public class NumberOfWaysTopological {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Graph representation
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] road : roads) {
            graph.get(road[0]).add(new Edge(road[1], road[2]));
            graph.get(road[1]).add(new Edge(road[0], road[2]));
        }

        // Topological sorting using Kahn's algorithm (since this is a weighted graph,
        // we don't guarantee a DAG, but we can still try to process nodes in a
        // meaningful order)
        int[] inDegree = new int[n];
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Priority queue for processing nodes in increasing order of distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 }); // [distance, node]

        // Process nodes using a BFS-like method, but weighted
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if (time > dist[node])
                continue;

            // Process each neighbor
            for (Edge edge : graph.get(node)) {
                int neighbor = edge.to;
                int newTime = time + edge.weight;

                // If a shorter path is found
                if (newTime < dist[neighbor]) {
                    dist[neighbor] = newTime;
                    ways[neighbor] = ways[node]; // Inherit ways from the current node
                    pq.offer(new int[] { newTime, neighbor });
                } else if (newTime == dist[neighbor]) {
                    // If another shortest path is found, add ways
                    ways[neighbor] = (ways[neighbor] + ways[node]) % MOD;
                }
            }
        }

        // The number of ways to reach the destination node (n-1)
        return ways[n - 1];
    }

    public static void main(String[] args) {
        NumberOfWaysTopological solution = new NumberOfWaysTopological();
        int n = 7;
        int[][] roads = {
                { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 }, { 2, 5, 1 },
                { 0, 4, 5 }, { 4, 6, 2 }
        };
        System.out.println(solution.countPaths(n, roads)); // Output: 4
    }
}
