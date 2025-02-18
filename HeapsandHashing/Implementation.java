package HeapsandHashing;

import java.util.ArrayList;

// import trees.minimumdepth;

public class Implementation {

    public static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int val) {
            heap.add(val);

            int x = heap.size() - 1;
            int par = (x - 1) / 2;

            while (heap.get(x) < heap.get(par)) {
                int temp = heap.get(x);
                heap.set(x, heap.get(par));
                heap.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int data = heap.get(0);

            // first swap the value with root and last node
            int temp = heap.get(heap.size() - 1);
            heap.set(0, temp);
            heap.set(heap.size() - 1, data);

            // second remove the last node from the Ayyalist
            heap.remove(heap.size() - 1);
            heapify(0);

            return data;

        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < heap.size() && heap.get(minIdx) > heap.get(left)) {
                minIdx = left;
            }

            if (right < heap.size() && heap.get(minIdx) > heap.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = heap.get(minIdx);
                heap.set(minIdx, heap.get(i));
                heap.set(i, temp);
                heapify(minIdx);
            }
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(1);
        h.add(5);
        h.add(2);
        h.add(4);
        h.add(3);
        h.add(6);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }

    }
}
