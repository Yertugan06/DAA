package code;

import java.util.*;

public class DeterministicSelect {

    private static final int GROUP_SIZE = 5;

    public static int select(int[] arr, int k) {
        if (k < 1 || k > arr.length)
            throw new IllegalArgumentException("k out of bounds");
        return select(arr, 0, arr.length - 1, k - 1); // shift to 0-based
    }

    private static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) return arr[left];

            int pivotIndex = medianOfMedians(arr, left, right);
            pivotIndex = partition(arr, left, right, pivotIndex);

            if (k == pivotIndex) {
                return arr[k];
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right); // move pivot to end
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;

        if (n <= GROUP_SIZE) {
            return partition5(arr, left, right);
        }

        int numMedians = 0;
        for (int i = left; i <= right; i += GROUP_SIZE) {
            int subRight = Math.min(i + GROUP_SIZE - 1, right);
            int median5 = partition5(arr, i, subRight);
            swap(arr, left + numMedians, median5); // move median into first part
            numMedians++;
        }

        // recursive call to find median of medians by index (not value!)
        int midIndex = left + numMedians / 2;
        return selectIndex(arr, left, left + numMedians - 1, midIndex);
    }

    // helper that returns index of kth element, not value
    private static int selectIndex(int[] arr, int left, int right, int kIndex) {
        while (true) {
            if (left == right) return left;

            int pivotIndex = medianOfMedians(arr, left, right);
            pivotIndex = partition(arr, left, right, pivotIndex);

            if (kIndex == pivotIndex) {
                return pivotIndex;
            } else if (kIndex < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private static int partition5(int[] arr, int left, int right) {
        Arrays.sort(arr, left, right + 1);
        return left + (right - left) / 2; // return index of median
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
