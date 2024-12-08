import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {
        // Use a HashSet to store the elements we've seen so far
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if the current number's double or half exists in the set
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }

        return false;
    }
}
