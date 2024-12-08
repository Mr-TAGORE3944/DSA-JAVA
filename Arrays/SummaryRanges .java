import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;

        if (n == 0)
            return list; // If the array is empty, return an empty list

        for (int i = 0; i < n; i++) {
            int start = nums[i]; // Start of the range

            // Move `i` forward while we have a consecutive range
            while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // If start equals the current number, it’s a single number range
            if (start == nums[i]) {
                list.add(String.valueOf(start));
            } else {
                // Otherwise, we have a range from start to nums[i]
                list.add(start + "->" + nums[i]);
            }
        }

        return list;
    }
}
