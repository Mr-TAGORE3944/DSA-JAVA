import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0)
            return ranges;

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // Check if we reached the end of a range
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // Single number range
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(start));
                } else {
                    // Range with multiple numbers
                    ranges.add(start + "->" + nums[i - 1]);
                }
                // Update the start for the next range if there's more to process
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return ranges;
    }
}
