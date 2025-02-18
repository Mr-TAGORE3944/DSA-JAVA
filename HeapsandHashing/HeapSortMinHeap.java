package HeapsandHashing;

public class HeapSortMinHeap {

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        // Compare parent with left child
        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }

        // Compare parent (or updated max) with right child
        if (right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }

        // If the max is not the parent, swap and continue heapifying
        if (maxIdx != i) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapsort(int arr[]) {
        int n = arr.length;

        // Step 1: Build the max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (max) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore the heap property for the reduced heap
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 8, 5, 2, 7, 4, 1 };
        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        heapsort(arr);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
