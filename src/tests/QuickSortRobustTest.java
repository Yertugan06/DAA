package tests;

import code.QuickSortRobust;

import java.util.*;

public class QuickSortRobustTest {
    public static void main(String[] args) {
        System.out.println("--- QuickSortRobust Tests ---");

        // Random arrays
        Random rand = new Random(42);
        for (int trial = 0; trial < 5; trial++) {
            int[] arr = rand.ints(20, -100, 100).toArray();
            int[] copy = arr.clone();

            QuickSortRobust.quickSort(arr);
            Arrays.sort(copy);

            System.out.println("Trial " + trial + " -> " + Arrays.equals(arr, copy));
        }

        // Adversarial array
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        int[] copy = arr.clone();
        QuickSortRobust.quickSort(arr);
        Arrays.sort(copy);
        System.out.println("Adversarial sorted input -> " + Arrays.equals(arr, copy));

        // Depth bound
        int n = 5000;
        int[] big = rand.ints(n, -1_000_000, 1_000_000).toArray();
        QuickSortRobust.quickSort(big);
        int depth = QuickSortRobust.getMaxDepth();
        int expected = 2 * (int)(Math.log(n)/Math.log(2)) + 10;
        System.out.println("Recursion depth = " + depth + ", expected ≤ " + expected);
    }
}
