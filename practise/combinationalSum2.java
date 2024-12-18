package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import queue.interleave_1_to_2_halfs;

public class combinationalSum2 {

    public static List<List<Integer>> combination(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int nums[], int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip the duplicate elements from array;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        System.out.println(combination(nums, target));
        System.out.println(Ans(nums, target));

    }

    // practise

    public static List<List<Integer>> Ans(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        ans(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void ans(int[] nums, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            ans(nums, target - nums[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
