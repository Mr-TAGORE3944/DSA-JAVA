import java.util.*;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to make it easier to skip duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates: the condition has been modified here
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums, used, current, result);
                // Backtrack
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII perm = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = perm.permuteUnique(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
