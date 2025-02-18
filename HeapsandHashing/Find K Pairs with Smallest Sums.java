import java.util.*;

public class KSmallestPairs {
    // Custom pair class to store the pair and the sum
    static class Pair {
        int num1, num2, idx2;

        Pair(int num1, int num2, int idx2) {
            this.num1 = num1;
            this.num2 = num2;
            this.idx2 = idx2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge cases
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap to store pairs (sum, index in nums1, index in nums2)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.num1 + a.num2) - (b.num1 + b.num2));

        // Initialize heap with pairs (nums1[i], nums2[0]) for all i
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }

        // Extract k pairs from the heap
        while (!pq.isEmpty() && result.size() < k) {
            Pair current = pq.poll();
            result.add(Arrays.asList(current.num1, current.num2));

            // If there's more elements in nums2 to pair with current.num1, push the next
            // pair
            if (current.idx2 + 1 < nums2.length) {
                pq.offer(new Pair(current.num1, nums2[current.idx2 + 1], current.idx2 + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KSmallestPairs solution = new KSmallestPairs();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;

        // Expected output: [[1, 2], [1, 4], [1, 6]]
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }
}
