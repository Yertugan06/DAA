package tests;

import code.MergeSort;

import java.util.*;

public class MergeSortTest {
    public static void main(String[] args) {
        System.out.println("--- MergeSort Tests ---");

        Random rand = new Random(24);
        for (int trial = 0; trial < 5; trial++) {
            int[] arr = rand.ints(20, -50, 50).toArray();
            int[] copy = arr.clone();

            MergeSort.sort(arr);
            Arrays.sort(copy);

            System.out.println("Trial " + trial + " -> " + Arrays.equals(arr, copy));
        }

        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) arr[i] = 50 - i;
        int[] copy = arr.clone();
        MergeSort.sort(arr);
        Arrays.sort(copy);
        System.out.println("Adversarial descending input -> " + Arrays.equals(arr, copy));
    }
}
