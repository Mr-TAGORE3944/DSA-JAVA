import java.util.*;

public class Solution {

    // Function to calculate the minimum cost to connect all points
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Min-heap to store edges (distance, point index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Array to track visited points
        boolean[] visited = new boolean[n];
        
        // Start with the 0th point, (0, 0) means 0 distance from itself
        minHeap.offer(new int[]{0, 0});
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            // Get the edge with the smallest distance
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int point = curr[1];
            
            // If this point is already visited, skip it
            if (visited[point]) continue;
            
            // Mark the point as visited
            visited[point] = true;
            
            // Add the cost to the total
            totalCost += cost;
            edgesUsed++;
            
            // Check the cost of connecting this point to all other points
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                if (!visited[nextPoint]) {
                    // Calculate the Manhattan distance between the current point and the next point
                    int nextCost = Math.abs(points[point][0] - points[nextPoint][0])
                                 + Math.abs(points[point][1] - points[nextPoint][1]);
                    // Add the edge (distance, next point) to the heap
                    minHeap.offer(new int[]{nextCost, nextPoint});
                }
            }
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(solution.minCostConnectPoints(points));  // Output: 20
    }
}
