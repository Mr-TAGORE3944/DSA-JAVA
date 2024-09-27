import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int farthest = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (i == n - 1) {
                return true;
            }

            // Start checking from the farthest point we've reached so far
            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    queue.offer(j);
                }
            }

            // Update the farthest point reached
            farthest = end;
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGameVII solution = new JumpGameVII();
        System.out.println(solution.canReach("011010", 2, 3)); // Output: true
        System.out.println(solution.canReach("01101110", 2, 3)); // Output: false
    }
}
