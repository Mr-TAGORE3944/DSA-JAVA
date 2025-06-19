import java.util.*;

public class KSmallPair {

    public class Pair {
        int num1;
        int num2;
        int idx;

        public Pair(int num1, int num2, int idx) {
            this.num1 = num1;
            this.num2 = num2;
            this.idx = idx;
        }
    }

    public static List<List<Integer>> find(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length <= 0 || nums2.length <= 0 || k == 0 || nums1 == null || nums2 == null)
            return result;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.num1 + a.num2) - (b.num1 + b.num2));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Pair(nums1[i], nums2[0], 0));
        }

        while (!pq.isEmpty() && result.size() < k) {
            Pair curr = pq.poll();
            result.add(Arrays.asList(curr.num1, curr.num2));

            if (curr.idx + 1 < nums2.length) {
                pq.offer(new Pair(curr.num1, nums2[curr.idx + 1], curr.idx + 1));
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
    }
}
