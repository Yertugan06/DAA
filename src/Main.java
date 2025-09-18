import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // QUICK SORT
        System.out.println("--- Correctness Test for QuickSort ---");

        int[] arr = {9, 3, 2, 7, 6, 1, 5, 8, 4, 10, 12, 11};
        System.out.println("Original Array: " + Arrays.toString(arr));
        QuickSortRobust.quickSort(arr);
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
        System.out.println();

        //MERGE SORT

        System.out.println();

        //DETERMINISTIC SELECT

        System.out.println("--- Correctness Test for DeterministicSelect ---");
        int[] arr1 = {9, 3, 2, 7, 6, 1, 5, 8, 4, 10, 12, 11};
        int k = 6;
        int val = DeterministicSelect.select(arr1, k);
        QuickSortRobust.quickSort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("The " + k + "-th smallest element is: " + val);
        System.out.println();

        // CLOSEST PAIR OF POINTS

        System.out.println();
    }
}