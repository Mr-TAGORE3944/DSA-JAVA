public class SeparateBalls {

    public static void separateBalls(char[] balls) {
        int left = 0;
        int right = balls.length - 1;

        while (left < right) {
            // Move left pointer to the right until we find a white ball
            while (left < right && balls[left] == 'B') {
                left++;
            }
            // Move right pointer to the left until we find a black ball
            while (left < right && balls[right] == 'W') {
                right--;
            }
            // Swap black ball from right side with white ball from left side
            if (left < right) {
                char temp = balls[left];
                balls[left] = balls[right];
                balls[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        char[] balls = { 'W', 'B', 'W', 'B', 'B', 'W', 'B', 'W' };
        System.out.println("Before Separation: ");
        System.out.println(java.util.Arrays.toString(balls));

        separateBalls(balls);

        System.out.println("After Separation: ");
        System.out.println(java.util.Arrays.toString(balls));
    }
}
