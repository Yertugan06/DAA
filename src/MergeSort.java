public class MergeSort {

    public static void sort(int[] array) {
        int[] buffer = new int[array.length];
        mergeSort(array, buffer, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] buffer, int left, int right) {
        if (right - left < 20) {
            insertionSort(array, left, right);
            return;
        }

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, buffer, left, mid);
            mergeSort(array, buffer, mid + 1, right);
            merge(array, buffer, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                buffer[k++] = array[i++];
            } else {
                buffer[k++] = array[j++];
            }
        }

        while (i <= mid) buffer[k++] = array[i++];
        while (j <= right) buffer[k++] = array[j++];

        for (int p = left; p <= right; p++) {
            array[p] = buffer[p];
        }
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
