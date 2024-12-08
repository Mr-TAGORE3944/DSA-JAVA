import java.util.Arrays;

public class MinArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort balloons by their ending position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow is needed
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the end of the previous one
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        MinArrowsToBurstBalloons solution = new MinArrowsToBurstBalloons();

        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println("Minimum arrows needed: " + solution.findMinArrowShots(points));
    }
}
