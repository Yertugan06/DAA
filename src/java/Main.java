package java;

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

        // MERGE SORT
        System.out.println("--- Correctness Test for java.MergeSort ---");

        int[] arr2 = {15, 7, 20, 3, 9, 18, 1, 5, 12, 30};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        MergeSort.sort(arr2);
        System.out.println("Sorted Array:   " + Arrays.toString(arr2));
        System.out.println();

        // DETERMINISTIC SELECT
        System.out.println("--- Correctness Test for java.DeterministicSelect ---");
        int[] arr1 = {9, 3, 2, 7, 6, 1, 5, 8, 4, 10, 12, 11};
        int k = 6;
        int val = DeterministicSelect.select(arr1, k);
        QuickSortRobust.quickSort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        System.out.println("The " + k + "-th smallest element is: " + val);
        System.out.println();

        // CLOSEST PAIR OF POINTS
        System.out.println("--- Correctness Test for ClosestPairOfPoint2D ---");

        Point[] points = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        Result res = ClosestPairOfPoint2D.FindClosestPairs(points);
        System.out.println("The closest distance is " + Math.sqrt(res.distSq));
        System.out.println("Between points (" + res.p1.getX() + ", " + res.p1.getY() +
                ") and (" + res.p2.getX() + ", " + res.p2.getY() + ")");
        System.out.println();
    }
}
