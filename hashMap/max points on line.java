import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        if (n == 1) return 1;  // Only one point, so the max is 1
        
        int maxPointsOnLine = 0;
        
        // Iterate over each point
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int samePoint = 1;  // Points that are the same as point[i]
            int maxPointsForCurrentPoint = 0;
            
            // Compare point i with every other point
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if (x1 == x2 && y1 == y2) {
                    // Overlapping point
                    samePoint++;
                } else {
                    // Calculate slope (dy/dx) as a fraction
                    int dx = x2 - x1;
                    int dy = y2 - y1;
                    
                    // Reduce fraction by dividing both numerator and denominator by their GCD
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    
                    // To handle negative slopes consistently, ensure dx is always positive
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    
                    // Store slope as a string "dy/dx"
                    String slope = dy + "/" + dx;
                    
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                    maxPointsForCurrentPoint = Math.max(maxPointsForCurrentPoint, slopeMap.get(slope));
                }
            }
            
            // Update global max (include same points)
            maxPointsOnLine = Math.max(maxPointsOnLine, maxPointsForCurrentPoint + samePoint);
        }
        
        return maxPointsOnLine;
    }
    
    // Helper function to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
