package Sorting;

import java.util.PriorityQueue;

public class radix_sort {

    static void AdvCountSort(int[] arr, int place) {
        int n = arr.length;

        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / place) % 10]++;
        }

        int[] output = new int[n];
        // make prefix sum of count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = count[(arr[i] / place) % 10] - 1;
            output[idx] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
    }

    public static class Short implements Comparable<Short> {
        int i;

        Short(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Short o) {
            return o.i % 10 - this.i % 10;
        }
    }

    public static void print() {
        PriorityQueue<Short> pq = new PriorityQueue<>();
        pq.add(new Short(9));
        pq.add(new Short(5));
        pq.add(new Short(30));
        pq.add(new Short(34));
        pq.add(new Short(10));
        pq.add(new Short(2));
        System.out.println();
        while (!pq.isEmpty()) {
            System.out.print(pq.poll().i + " ");
        }

    }

    static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    static void RadixSort(int[] arr) {
        int n = arr.length;
        int max = findMax(arr);
        int[] count = new int[10];
        for (int place = 1; max / place > 0; place *= 10) {
            AdvCountSort(arr, place);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 7, 9, 3, 54, 7, 90, 5, 89, 4, 45, 65 };

        RadixSort(arr);
        displayArray(arr);
        print();

    }
}
