import java.util.*;
public class Permutation2 {



    public static List<List<Integer>> permute(int []nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums , used , new ArrayList<>() , result);
        return result;
    }

    public static void backtrack(int[] nums  , boolean[] used , List<Integer> current , List<List<Integer>> result){
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i-1] && !used[i]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }

        }

    }
    

    public static List<List<Integer>> Ans(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        ans(nums , used , new ArrayList<>() , result);
        return result;
    }

    public static void ans(int nums[] , boolean[] used , List<Integer> current , List<List<Integer>> result){
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i-1] && !used[i]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                ans(nums, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        for(List<Integer> list : result){
            System.out.println(list);
        }
        System.out.println();
        result = new ArrayList<>();
        result = Ans(nums);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }
}
