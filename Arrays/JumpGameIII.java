public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        // Base case: if start is out of bounds or this index is already visited, return
        // false
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        // Base case: if we reach an index with value 0, return true
        if (arr[start] == 0) {
            return true;
        }

        // Mark the current index as visited by negating the value at this index
        arr[start] = -arr[start];

        // Try jumping to the left and right
        boolean canJumpLeft = canReach(arr, start - Math.abs(arr[start]));
        boolean canJumpRight = canReach(arr, start + Math.abs(arr[start]));

        // Return true if either direction leads to a solution
        return canJumpLeft || canJumpRight;
    }

    public static void main(String[] args) {
        JumpGameIII solution = new JumpGameIII();
        int[] arr1 = { 4, 2, 3, 0, 3, 1, 2 };
        int[] arr2 = { 4, 2, 3, 0, 3, 1, 2 };
        int[] arr3 = { 3, 0, 2, 1, 2 };

        System.out.println(solution.canReach(arr1, 5)); // Output: true
        System.out.println(solution.canReach(arr2, 0)); // Output: true
        System.out.println(solution.canReach(arr3, 2)); // Output: false
    }
}
