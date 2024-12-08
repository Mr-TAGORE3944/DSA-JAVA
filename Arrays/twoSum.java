import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(num[i], i);
        }

        // If no solution is found, return an empty array or handle as needed
        return new int[0];
    }
}
