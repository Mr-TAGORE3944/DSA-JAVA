package HeapsandHashing;

public class HeapSort {

    public static void heapify(int arr[], int i, int size) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < size && arr[minIdx] > arr[left]) {
            minIdx = left;
        }

        if (right < size && arr[minIdx] > arr[right]) {
            minIdx = right;
        }

        if (minIdx != i) {
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            heapify(arr, minIdx, size);
        }
    }

    public static void heapsort(int arr[]) {
        int n = arr.length;
        // build - max heap;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // push largest at end

        for (int i = n - 1; i >= 0; i--) {
            // swap largest with end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {

    }
}
