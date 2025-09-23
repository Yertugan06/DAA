package tests;

import code.DeterministicSelect;

import java.util.*;

public class DeterministicSelectTest {
    public static void main(String[] args) {
        System.out.println("--- DeterministicSelect Tests ---");

        Random rand = new Random(77);
        boolean allGood = true;

        for (int trial = 0; trial < 20; trial++) {
            int n = rand.nextInt(30) + 10;
            int[] arr = rand.ints(n, -100, 100).toArray();
            int k = rand.nextInt(n) + 1;

            int[] copy = arr.clone();
            Arrays.sort(copy);
            int expected = copy[k - 1];
            int actual = DeterministicSelect.select(arr, k);

            if (expected != actual) {
                System.out.println("Mismatch at trial " + trial + ": expected " + expected + " got " + actual);
                allGood = false;
            }
        }

        if (allGood) {
            System.out.println("All trials passed!");
        }
    }
}
