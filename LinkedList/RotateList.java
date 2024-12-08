import java.util.*;

public class RotateList {
    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        if (n == 0)
            return;
        k = k % n; // Handle rotations larger than the list size
        if (k < 0)
            k += n; // Handle negative rotations

        Collections.reverse(list.subList(0, n - k));
        Collections.reverse(list.subList(n - k, n));
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int k = 2; // Number of rotations
        rotate(list, k);
        System.out.println(list); // Output: [5, 6, 1, 2, 3, 4]
    }
}
