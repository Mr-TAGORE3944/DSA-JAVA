import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n]; // Histogram heights
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Update the heights array for the current row
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1; // Increment height if current cell is '1'
                } else {
                    heights[j] = 0; // Reset height to 0 if current cell is '0'
                }
            }
            // Calculate the maximum area for the histogram represented by the heights array
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Helper function to calculate the largest rectangle area in a histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through the heights array
        for (int i = 0; i <= n; i++) {
            // Append a 0 height to handle remaining bars in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // Pop from stack while the current height is less than the height at the
            // stack's top index
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()]; // Height of the popped bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate the width
                maxArea = Math.max(maxArea, h * width); // Calculate the area
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return maxArea;
    }
}
