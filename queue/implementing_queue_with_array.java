package queue;

public class implementing_queue_with_array {

    public static class queueArray {
        int r = -1;
        int f = -1;
        int[] arr = new int[5];
        int size = 0;

        public void add(int val) {
            if (r == arr.length - 1) {
                System.out.println("Queue is full!");
                return;
            }
            if (f == -1) {
                f = r = 0;
                arr[0] = val;
                size++;
            } else {
                arr[++r] = val;
                size++;
            }
        }

        public int pop() {
            if (size == 0) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            f++;
            size--;
            return arr[f - 1];
        }

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[f];
        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is Empty!");
                return;
            }
            for (int i = f; i <= r; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {

        queueArray q = new queueArray();
        q.display();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(4);
        q.add(5);
        q.display();
    }
}
