package java;

import java.util.Random;

public class QuickSortRobust {
    private static final Random rand = new Random();
    private static int maxDepth;  // track maximum recursion depth

    public static void quickSort(int[] arr) {
        maxDepth = 0; // reset before each sort
        quickSort(arr, 0, arr.length - 1, 1); // start depth = 1
    }

    private static void quickSort(int[] arr, int low, int high, int depth) {
        while (low < high) {
            maxDepth = Math.max(maxDepth, depth); // record depth

            // Randomized pivot selection
            int pivotIndex = low + rand.nextInt(high - low + 1);
            int pivot = arr[pivotIndex];

            // Partition step
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                if (i <= j) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }

            // Recurse on the smaller partition
            if (j - low < high - i) {
                if (low < j) {
                    quickSort(arr, low, j, depth + 1);
                }
                low = i; // tail recursion on the larger side
            } else {
                if (i < high) {
                    quickSort(arr, i, high, depth + 1);
                }
                high = j; // tail recursion on the larger side
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // ✅ Public accessor for max recursion depth
    public static int getMaxDepth() {
        return maxDepth;
    }
}
