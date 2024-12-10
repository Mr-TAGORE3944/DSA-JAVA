import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // If the map contains the number and the difference in indices is <= k
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }

            // Update the map with the current index of the number
            map.put(num, i);
        }

        return false;
    }
}
