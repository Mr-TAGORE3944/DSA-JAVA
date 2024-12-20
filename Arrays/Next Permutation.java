class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the rightmost successor
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap pivot with successor
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

// <!--
// /*Sure! Here's a brief, step-by-step explanation of how to find the "Next
// Permutation":

// ### Step 1: Identify the Pivot
// - **Goal:** Find the first decreasing element when scanning from right to
// left.
// - **How:** Start from the end of the array and move left until you find an
// element that is smaller than the one next to it.
// - **Example:** In `[1, 2, 3]`, `2` is the pivot because `2 < 3`.

// ### Step 2: Find the Successor
// - **Goal:** Find the smallest element on the right of the pivot that is
// larger than the pivot.
// - **How:** Scan from the end of the array to the pivot, and stop at the first
// element that is larger than the pivot.
// - **Example:** In `[1, 2, 3]`, `3` is the successor to `2`.

// ### Step 3: Swap Pivot and Successor
// - **Goal:** Swap the pivot with its successor to increase the permutation.
// - **Example:** Swapping `2` and `3` in `[1, 2, 3]` gives `[1, 3, 2]`.

// ### Step 4: Reverse the Suffix
// - **Goal:** Rearrange the elements after the pivot (now at the new position)
// to get the smallest lexicographical order.
// - **How:** Reverse the subarray to the right of the original pivot's
// position.
// - **Example:** The suffix is `[2]`, which is already sorted, so `[1, 3, 2]`
// is the final result.

// ### Special Case:
// - If no pivot is found (i.e., the array is entirely non-increasing like `[3,
// 2, 1]`), simply reverse the whole array to get the smallest permutation.

// ### Result:
// - The array now represents the next permutation in lexicographical order.*/
// -->