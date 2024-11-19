import java.util.Arrays;

import backtracking.printPermutations;

public class findMinArrowShots {

    // public class Pair implements Comparator {
    // int start;
    // int end;

    // Pair(int start, int end) {
    // this.start = start;
    // this.end = end;
    // }
    // }

    public static int solution(int[][] points) {
        int n = points.length;
        int arrows = 1;

        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.start < b.start);

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int currentEnd = points[0][1];

        for (int i = 1; i < n; i++) {
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;

    }

    public static void main(String[] args) {

        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int[][] points2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

        System.out.println(solution(points));
        System.out.println(solution(points2));

    }
}
